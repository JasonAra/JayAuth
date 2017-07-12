package com.exapot;

import java.security.SecureRandom;

/**
 * Created by Jason Ara (Jay.Ara) on 7/11/17.
 * From https://www.exapot.com
 */
public class HashToken {
    private final String generalCharSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private String tokenizing(String charSet, int size) {
        final SecureRandom random = new SecureRandom();
        StringBuilder token = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            token.append(charSet.charAt(random.nextInt(charSet.length())));
        }
        return token.toString();
    }

    private String randoming(String charSet, int size) {
        final SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(charSet);
        StringBuilder token = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            int n = random.nextInt(sb.length());
            token.append(sb.charAt(n));
            sb.deleteCharAt(n);
        }
        return token.toString();
    }

    public String getToken() {
        String unq = tokenizing(generalCharSet, 7) + System.currentTimeMillis();
        return randoming(unq, unq.length());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(new HashToken().getToken());

        }
    }
}
