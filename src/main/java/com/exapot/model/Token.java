package com.exapot.model;

/**
 * Created by Ehsaniara
 * From https://www.exapot.com
 */
public interface Token {
    Object getUserObject();

    void setUserObject(Object userObject);

    long getUserId();

    void setUserId(long userId);

    String getTokenValue();

    void setTokenValue(String tokenValue);

    long getExpDate();

    void setExpDate(long expDate);
}
