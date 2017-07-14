package com.exapot;

/**
 * Created by Jason Ara (Jay.Ara) on 7/12/17.
 * From https://www.exapot.com
 */
public @interface SecureToken {
    String name() default "";

    String[] headers() default {};
}
