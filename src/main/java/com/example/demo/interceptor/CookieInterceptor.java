package com.example.demo.interceptor;


import com.example.demo.commons.utils.CookieUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

public class CookieInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        // 如果不是映射到方法直接通过
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        //设置cookie的名称
        String cookieName="global_session_id";
        String encodeString="UTF-8";
        String cookieValue = CookieUtils.getCookieValue(request, cookieName, encodeString);
        if(null == cookieValue || "".equals(cookieValue.trim())){
            System.out.println("无cookie，生成新的cookie数据");
            cookieValue = UUID.randomUUID().toString();
        }
        // 根据cookieValue访问数据存储，获取客户端数据。
        CookieUtils.setCookie(request, response, cookieName, cookieValue, 0, encodeString);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
