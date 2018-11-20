/*
 * Copyright © 2017 Nedbank. All rights reserved.
 */

package com.daggerdemo.network.exception;


public class NullBaseUrlException extends RuntimeException {
    @Override
    public String getMessage() {
        return "baseURL == null";
    }
}
