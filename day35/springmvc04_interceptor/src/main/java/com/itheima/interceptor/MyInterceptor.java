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

public class MyInterceptor implements HandlerInterceptor {

    //前置增强 当方法返回值为true时：表示放行 会执行Controller类中的目标方法
    //                   false：则不放行 直接在这里返回  建议在preHandle方法中设置响应内容，方便提醒用户
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor preHandle...");

        response.setContentType("text/html;charset=UTF-8");
        /*response.getWriter().print("拒绝访问！");
        return false;*/

        return true;
    }

    //后置增强  当目标方法正常执行完毕时 才会执行该方法
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor postHandle...");
    }

    //最终增强  当目标方法执行后 就会执行该方法 【不管目标方法执行成功与否】
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor afterCompletion...");
    }
}
