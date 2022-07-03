package com.itheima.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器配置使用：
 *  1.定义一个拦截器类 实现HandlerInterceptor接口,重写3个方法
 *  2.配置拦截器拦截请求路径
 *
 */

public class MyInterceptor03 implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor03 preHandle...");

        return false;
    }

    //后置增强  当目标方法正常执行完毕时 才会执行该方法
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor03 postHandle...");
    }

    //最终增强  当目标方法执行后 就会执行该方法 【不管目标方法执行成功与否】
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor03 afterCompletion...");
    }
}
