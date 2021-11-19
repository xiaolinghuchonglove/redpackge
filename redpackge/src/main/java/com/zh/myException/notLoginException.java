package com.zh.myException;

public class notLoginException extends  RuntimeException{
    private String msg;

    public notLoginException(String msg) {
        this.msg = msg;
    }
}
