package com.exapot.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ehsaniara
 * From https://www.exapot.com
 */
public abstract class TokenCore {

    private long userId;
    private String tokenValue;
    private String tokenSeed;
    private Object object;
    private long expDate;
    private Map<String, String> headers = new HashMap<>();

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }

    public long getExpDate() {
        return expDate;
    }

    public void setExpDate(long expDate) {
        this.expDate = expDate;
    }

    public String getTokenSeed() {
        return tokenSeed;
    }

    public void setTokenSeed(String tokenSeed) {
        this.tokenSeed = tokenSeed;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }
}
