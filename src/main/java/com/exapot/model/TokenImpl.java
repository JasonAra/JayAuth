package com.exapot.model;

/**
 * Created by Jason Ara (Jay.Ara) on 7/11/17.
 * From https://www.exapot.com
 */
public class TokenImpl extends TokenCore implements Token {

    public TokenImpl(Object userObject) {
        setUserObject(userObject);
    }
}
