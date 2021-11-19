package com.zh.myException;

public class myExceptionFactory {
    public static RuntimeException e;

    public static RuntimeException createMyException(String s) {
        if(s.equals("未登录"))
            e = new notLoginException(s);
        return e;
    }
}
