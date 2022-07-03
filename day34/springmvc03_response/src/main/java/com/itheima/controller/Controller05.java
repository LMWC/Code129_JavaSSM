package com.itheima.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
    常用注解：
        @PathVariable：用于获取url地址中的部分数据 赋值给方法形参
            属性：
                value：设置占位符参数名称  如果方法形参变量名和占位符名称一致，则无需设置value属性
            使用：
                1.设置请求映射地址时，使用占位符占位
                2.获取占位符参数数据时，要在方法形参前打上@PathVariable
            注意：
                1.请求地址中的占位符可以有多个  @PathVariable也可以在一个方法中使用多次

       @RequestHeader：用于获取指定名称的请求头的值，赋值给方法形参
            属性：
                value：设置要获取值的请求头名称
            使用：打在方法形参前面
            注意：如果请求头名称设置错误，则会报400错误
      @CookieValue：用于获取指定名称的Cookie的值，赋值给方法形参
            属性：
                value：设置要获取值的Cookie名称
            使用：打在方法形参前面
            注意：如果Cookie名称设置错误，则会报400错误
 */
@Controller
public class Controller05 {

    @ResponseBody
    @RequestMapping("/delete/{id}/{name}")
    public String pathVariable(@PathVariable int id,@PathVariable String name){
        System.out.println("pathVariable....");
        System.out.println("id = " + id);
        System.out.println("name = " + name);
        return "success";
    }

    @ResponseBody
    @RequestMapping("/requestHeader")
    public String requestHeader(@RequestHeader("user-agent") String value){
        System.out.println("requestHeader....");
        System.out.println("value = " + value);
        return "success";
    }

    @ResponseBody
    @RequestMapping("/cookieValue")
    public String cookieValue(@CookieValue("JSESSIONID") String value){
        System.out.println("requestHeader....");
        System.out.println("value = " + value);
        return "success";
    }

}
