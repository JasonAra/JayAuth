package com.exapot.service;

import com.exapot.HashToken;
import com.exapot.model.Token;
import com.exapot.model.TokenImpl;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Map;


/**
 * Created by Ehsaniara
 * From https://www.exapot.com
 */
@Service
public class TokenServiceImpl implements TokenService {

    private long expTimeSec = 30 * 60 * 1000;


    public void setExpTimeSec(long expTimeSec) {
        this.expTimeSec = expTimeSec;
    }

    public String addObject(Object obj, long id) throws Exception {

        if (obj == null)
            throw new Exception("Null Object");

        if (id < 1)
            throw new Exception("Invalid Id");

        if (com.exapot.controller.TokenController.tokenMap.containsKey(id))
            throw new Exception("Id already exsist");

        Token token = new TokenImpl(obj);
        token.setUserId(id);
        token.setTokenValue(new HashToken().getToken());
        token.setExpDate(System.currentTimeMillis() + expTimeSec);
        com.exapot.controller.TokenController.tokenMap.put(id, token);
        return token.getTokenValue();
    }

    public boolean isTokenValid(String inToken) throws Exception {
        if (inToken == null || "".equals(inToken))
            throw new Exception("Invalid Token");

        for (Token value : com.exapot.controller.TokenController.tokenMap.values()) {
            if (value.getTokenValue().equals(inToken)) {

                if (value.getExpDate() > System.currentTimeMillis()) {
                    return true;
                } else {
                    removeObject(value.getUserId());
                    return false;
                }
            }
        }
        return false;
    }

    public Object getObject(String inToken) throws Exception {
        if (inToken == null || "".equals(inToken))
            throw new Exception("Invalid Token");

        for (Token value : com.exapot.controller.TokenController.tokenMap.values()) {

            if (value.getExpDate() < System.currentTimeMillis()) {
                removeObject(value.getUserId());
            }

            if (value.getTokenValue().equals(inToken) && value.getExpDate() > System.currentTimeMillis())
                return value.getUserObject();

        }
        return null;
    }

    public void removeObject(String inToken) throws Exception {
        if (inToken == null || "".equals(inToken))
            throw new Exception("Invalid Token");

        for (Iterator<Map.Entry<Long, Token>> it
             = com.exapot.controller.TokenController.tokenMap.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<Long, Token> entry = it.next();
            if (entry.getValue().equals(inToken)) {
                it.remove();
            }
        }
    }

    public void removeObject(long id) throws Exception {
        if (id < 1)
            throw new Exception("Invalid Id");

        for (Iterator<Map.Entry<Long, Token>> it
             = com.exapot.controller.TokenController.tokenMap.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<Long, Token> entry = it.next();
            if (entry.getKey() == id) {
                it.remove();
            }
        }
    }
}
