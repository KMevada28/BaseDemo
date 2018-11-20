/*
 * Copyright © 2017 Nedbank. All rights reserved.
 */

package com.daggerdemo.network.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {
    CachePolicy value() default CachePolicy.RETURN_CACHED_AND_QUERY;
}
