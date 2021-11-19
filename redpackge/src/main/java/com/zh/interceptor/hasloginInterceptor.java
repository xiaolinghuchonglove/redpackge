package com.zh.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zh.Ob.JsonResult;
import com.zh.Ob.ProcessType;
import com.zh.Ob.Status;
import com.zh.Utils.jwtUtils;
import com.zh.myException.myExceptionFactory;
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
//            token为空，没有登陆
            if(request.getHeader("token")==null)
                //方法一，通过统一异常处理
                throw myExceptionFactory.createMyException("未登录");
            //通过response返回处理结果

//            { //定义jakson核心类
//            ObjectMapper a = new ObjectMapper();
//            String json = a.writeValueAsString(new JsonResult(Status.fail, ProcessType.find, "您未登录请登录后在访问bs", null));
//设置编码和返回的数据类型
//            response.setContentType("application/json;charset=utf-8");
//            输出到前端
//            response.getWriter().println(json);
//            拦截对接口访问
//            return false;
//            }
//            验证token,如果失败剖出异常
            jwtUtils.verify(request.getHeader("token"));
            return true;
        } catch (Exception e) {
            throw  e;
        }
    }

}
