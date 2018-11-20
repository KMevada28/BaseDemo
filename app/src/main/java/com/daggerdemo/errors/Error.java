/*
 * Copyright © 2017 Nedbank. All rights reserved.
 */

package com.daggerdemo.errors;

/**
 * Created by kapilvij on 28/08/17.
 */

public class Error {
    private String message;
    private int code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
