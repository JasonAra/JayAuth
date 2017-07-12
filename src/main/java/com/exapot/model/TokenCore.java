package com.exapot.model;

/**
 * Created by Ehsaniara
 * From https://www.exapot.com
 */
public abstract class TokenCore {
    private long userId;
    private String tokenValue;
    private Object userObject;
    private long expDate;

    public Object getUserObject() {
        return userObject;
    }

    public void setUserObject(Object userObject) {
        this.userObject = userObject;
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
}
