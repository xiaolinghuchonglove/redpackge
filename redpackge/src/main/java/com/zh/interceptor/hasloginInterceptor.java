package com.zh.interceptor;

import com.zh.Utils.jwtUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class hasloginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {

            System.out.println("拦截到了");
            jwtUtils.verify(request.getHeader("token"));
            return true;
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            throw  e;
        }
    }

}
