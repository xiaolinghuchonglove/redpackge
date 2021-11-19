package com.zh.Ob;

public enum Status {
    success(200,"success"),fail(400,"fail"),
    hasRegisty(401,"fail");
    private int code;

    private String status;

    Status(int code, String status) {
        this.code = code;
        this.status = status;
    }

    Status() {
    }
}
