package com.exapot.service;

import com.exapot.HashToken;
import com.exapot.controller.TokenController;
import com.exapot.model.Token;
import com.exapot.model.TokenImpl;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.UUID;


/**
 * Created by Ehsaniara
 * From https://github.com/ehsaniara
 */
@Service
public class TokenServiceImpl implements TokenService {

    public void setExpTimeSec(int t) {
        TokenController.expTimeSec = t;
    }

    public String addToken(HttpServletRequest req,
                           HttpServletResponse res,
                           Object obj, long id) throws Exception {

        if (req == null)
            throw new Exception("Null HttpServletRequest");

        if (res == null)
            throw new Exception("Null HttpServletResponse");

        if (obj == null)
            throw new Exception("Null Object");

        if (id < 1)
            throw new Exception("Invalid Id");


        Token token = new TokenImpl(obj);
        token.setUserId(id);
        token.setTokenValue(new HashToken().getToken());
        token.setExpDate(System.currentTimeMillis() + TokenController.expTimeSec);
        token.setTokenSeed(UUID.randomUUID().toString());


        TokenController.tokenMap.put(id, token);
        res.setHeader(token.getTokenValue(), token.getTokenSeed());


        Enumeration<String> headerNames = req.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String element = headerNames.nextElement();
                System.out.println(element + ": " + req.getHeader(element));
                token.getHeaders().put(element, req.getHeader(element));
            }
        }


        System.out.println("TOKEN CREATED AS:" + token.getTokenValue());
        return token.getTokenValue();
    }

    public boolean isTokenValid(HttpServletRequest req,
                                HttpServletResponse res, String inToken) throws Exception {

        //controlling the token value
        if (inToken == null || "".equals(inToken))
            throw new Exception("Invalid Token");

        //some oldSchool cleaning
        final String token = inToken.replaceAll("[^a-zA-Z0-9\\\\s]", "");

        //controlling the req value
        if (req == null || req.getHeader(token) == null || "".equals(req.getHeader(token)))
            throw new Exception("Invalid Token");

        Iterator<Token> iterator = TokenController.tokenMap.values().iterator();
        while (iterator.hasNext()) {
            Token value = iterator.next();
            if (value.getTokenValue().equals(token)
                    && value.getTokenSeed().equals(req.getHeader(token))) {

                //user-agent check
                if (!value.getHeaders().get("user-agent").equals(req.getHeader("user-agent"))) {
                    removeToken(req, res, value.getUserId());
                    return false;
                }

                if (value.getExpDate() > System.currentTimeMillis()) {
                    return true;
                } else {
                    removeToken(req, res, value.getUserId());
                    return false;
                }
            }
        }
        return false;
    }

    public Object getObject(HttpServletRequest req,
                            HttpServletResponse res, String inToken) throws Exception {
        if (inToken == null || "".equals(inToken))
            throw new Exception("Invalid Token");

        //some oldSchool cleaning
        final String token = inToken.replaceAll("[^a-zA-Z0-9\\\\s]", "");

        Iterator<Token> iterator = TokenController.tokenMap.values().iterator();
        while (iterator.hasNext()) {
            Token value = iterator.next();

            //remove any object that is expired
            if (value.getExpDate() < System.currentTimeMillis()) {
                removeToken(req, res, value.getUserId());
            }

            if (value.getTokenValue().equals(token) && value.getExpDate() > System.currentTimeMillis())
                return value.getObject();

        }
        return null;
    }

    public void removeToken(HttpServletRequest req,
                            HttpServletResponse res, String inToken) throws Exception {
        if (inToken == null || "".equals(inToken))
            throw new Exception("Invalid Token");

        //some oldSchool cleaning
        final String token = inToken.replaceAll("[^a-zA-Z0-9\\\\s]", "");

        TokenController.tokenMap.entrySet().removeIf(entry -> entry.getValue().equals(token));
    }

    public void removeToken(HttpServletRequest req,
                            HttpServletResponse res, long id) throws Exception {
        if (id < 1)
            throw new Exception("Invalid Id");

        TokenController.tokenMap.entrySet().removeIf(entry -> entry.getKey() == id);
    }
}
