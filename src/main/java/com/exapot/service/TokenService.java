package com.exapot.service;

import org.springframework.stereotype.Service;

/**
 * Created by Ehsaniara
 * From https://www.exapot.com
 */
@Service
public interface TokenService {

    void setExpTimeSec(long expTimeSec);

    String addObject(Object obj, long id) throws Exception;

    boolean isTokenValid(String inToken) throws Exception;

    Object getObject(String inToken) throws Exception;

    void removeObject(String inToken) throws Exception;

    void removeObject(long id) throws Exception;
}
