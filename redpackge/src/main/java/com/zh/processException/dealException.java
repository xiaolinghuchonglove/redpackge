package com.zh.processException;

import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zh.Ob.JsonResult;
import com.zh.Ob.ProcessType;
import com.zh.Ob.Status;
import com.zh.myException.notLoginException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.SignatureException;

@ControllerAdvice
@Slf4j
public class dealException {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JsonResult deal(Exception e) {
        log.info(e.getClass().toString());
        e.printStackTrace();
//        未登录异常
        if(e instanceof notLoginException)
            return new JsonResult(Status.fail, ProcessType.find, "您未登录请登录后在访问", null);

//        秘钥错误
        if (e instanceof SignatureException)
            return new JsonResult(Status.fail, ProcessType.find, "秘钥错误", null);
        //token错误，验证失败
        if(e instanceof SignatureVerificationException)
            return new JsonResult(Status.fail, ProcessType.find, "token错误", null);
//        签名过期
        if (e instanceof TokenExpiredException)
            return new JsonResult(Status.fail, ProcessType.find, "登录过期，请重新登录", null);
        else
        {
//        其他情况
            return new JsonResult(Status.fail, ProcessType.find, "未知错误,请尝试重新登陆", null);
    }
}}