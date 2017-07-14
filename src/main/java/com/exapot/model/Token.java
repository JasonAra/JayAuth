package com.exapot.model;

import java.util.Map;

/**
 * Created by Ehsaniara
 * From https://www.exapot.com
 */
public interface Token {
    Object getObject();

    void setObject(Object object);

    long getUserId();

    void setUserId(long userId);

    String getTokenValue();

    void setTokenValue(String tokenValue);

    long getExpDate();

    void setExpDate(long expDate);

    String getTokenSeed();

    void setTokenSeed(String tokenSeed);

    Map<String, String> getHeaders();

    void setHeaders(Map<String, String> headers);
}
