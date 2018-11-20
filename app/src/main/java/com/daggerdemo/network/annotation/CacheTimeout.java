/*
 * Copyright © 2017 Demo_By_K_Mevada. All rights reserved.
 */

package com.daggerdemo.network.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface CacheTimeout {

    public static final long NEVER = 0L;

    long value() default NEVER;
}
