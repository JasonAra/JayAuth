package com.exapot.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Ehsaniara
 * From https://github.com/ehsaniara
 */
@Service
public interface TokenService {

    void setExpTimeSec(int expTimeSec);


    /**
     * Adding new session or replace with existing one
     *
     * @param req HttpServletRequest
     * @param res HttpServletResponse
     * @param obj any Custom Object EX: Customer,User,Operator,...
     * @param id  unique long value for that customer EX: customerId,userId,...
     * @return String the value of created token
     * @throws Exception in case of any Exception
     */
    String addToken(HttpServletRequest req,
                    HttpServletResponse res,
                    Object obj, long id) throws Exception;

    /**
     * Validating the token for any event
     *
     * @param req     HttpServletRequest
     * @param res     HttpServletResponse
     * @param inToken String the given token
     * @return boolean return TRUE if token is valid
     * @throws Exception
     */
    boolean isTokenValid(HttpServletRequest req,
                         HttpServletResponse res, String inToken) throws Exception;

    /**
     * to get Custom Object that was assigned at the @addToken @Method
     *
     * @param req     HttpServletRequest
     * @param res     HttpServletResponse
     * @param inToken String the given token
     * @return
     * @throws Exception
     */
    Object getObject(HttpServletRequest req,
                     HttpServletResponse res, String inToken) throws Exception;

    /**
     * Removing Token when you no longer need it
     *
     * @param req     HttpServletRequest
     * @param res     HttpServletResponse
     * @param inToken String
     * @throws Exception
     */
    void removeToken(HttpServletRequest req,
                     HttpServletResponse res, String inToken) throws Exception;

    /**
     * @param req HttpServletRequest
     * @param res HttpServletResponse
     * @param id  Long value assigned at the @addToken @Method
     * @throws Exception
     */
    void removeToken(HttpServletRequest req,
                     HttpServletResponse res, long id) throws Exception;
}
