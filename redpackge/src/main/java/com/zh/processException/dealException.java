package com.zh.processException;

import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.zh.Ob.JsonResult;
import com.zh.Ob.ProcessType;
import com.zh.Ob.Status;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.SignatureException;

@ControllerAdvice
public class dealException {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JsonResult deal(Exception e) {
        if (e instanceof SignatureException)
            return new JsonResult(Status.fail, ProcessType.find, "秘钥错误", null);
        if (e instanceof TokenExpiredException)
            return new JsonResult(Status.fail, ProcessType.find, "登录过期，请重新登录", null);
        if (e instanceof InvalidClaimException)
            return new JsonResult(Status.fail, ProcessType.find, "登录过期，请重新登录", null);
        else
        {
            e.getStackTrace();
            return new JsonResult(Status.fail, ProcessType.find, "未知错误", null);
    }
}}