package com.itheima.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GameInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        HandlerMethod method = (HandlerMethod) handler;
        //获取执行的类名
        String className = method.getBeanType().getName();
        //获取执行的方法名
        String methodName = method.getMethod().getName();
        System.out.println(className+":"+methodName+",开始执行时间为:"+System.currentTimeMillis());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        HandlerMethod method = (HandlerMethod) handler;
        //获取执行的类名
        String className = method.getBeanType().getName();
        //获取执行的方法名
        String methodName = method.getMethod().getName();
        System.out.println(className+":"+methodName+",执行结束时间为:"+System.currentTimeMillis());
    }
}
