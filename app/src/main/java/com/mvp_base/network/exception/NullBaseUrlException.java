/*
 * Copyright © 2017 Demo_By_K_Mevada. All rights reserved.
 */

package com.mvp_base.network.exception;


public class NullBaseUrlException extends RuntimeException {
    @Override
    public String getMessage() {
        return "baseURL == null";
    }
}
