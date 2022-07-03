package com.itheima.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
    @Controller：打在类上
        作用：
            1.是由Component注解衍生出来的，Spring识别到类上有这个注解，就会创建该类对象 放到IOC容器中管理
            2.表示当前类是一个控制器类，负责接收请求处理
    @RequestMapping：用于设置请求映射地址
        打在方法上：设置当前方法的请求映射地址
        打在类上：为当前方法中的所有请求设置一个统一的前缀  相当于是模块名称    请求地址映射：eg：/test/sayHi
        属性：
            value|path：设置请求映射地址  String[] 可以设置多个
            method：设置请求方式 RequestMethod[] 设置当前方法支持处理的请求方式
                没有设置请求方式，默认支持任何方式的请求
            parms：设置请求参数    String[]
                params = "name"：当前方法用户请求时必须携带name参数
                params = "name=aa"：当前方法用户请求时必须携带name参数,并且值为aa
                params = "name!=aa"：当前方法用户请求时可以不携带name参数,如果一旦携带name参数值不能为aa

        请求常见错误：
            1.HTTP Status 405 - Request method 'GET' not supported
               原因：前端使用的请求方式 和 后台处理要求的请求方式不一致
            2.HTTP Status 400
                原因：请求参数有问题  前端传递的请求参数和后台要求的请求参数不一致
 */
@RequestMapping("/test")
@Controller
public class Controller01 {
    @RequestMapping(value = {"/sayHi","/aa","/bb"},method = {RequestMethod.GET,RequestMethod.POST},params = "name=aa")
    public String sayHi(){
        System.out.println("Hello SpringMVC");
        return "success";
    }

    //物理视图：写一个视图的完整物理路径
    @RequestMapping("/sayHi02")
    public String sayHi02(){
        System.out.println("Hello SpringMVC");
        return "/a/b/c/d/success.jsp";
    }

     /*
        物理视图：写一个视图的完整物理路径 看起来直观 写起来麻烦
        逻辑视图：只需要写视图名称  需要配合视图解析器一起使用 通过视图解析器前缀设置视图所在路径  后缀设置视图的具体类型
            特点：写起来简单  不直观

            视图解析器根据路径视图名称找到具体的视图：前缀+视图名称+后缀   eg：/success.jsp

            注意：一旦使用了视图解析器后，物理视图也会被视图解析器解析，此时就可能出现404的情况
            解决：带前缀的物理视图  下午再讲
            问题1：如果我的项目中既响应的有jsp页面  还有html页面，这个时候视图解析器如何配置呢？
                说明：基本不会出现  尤其时现在的项目  现在的项目只需要返回json数据  使用html页面即可
            解决：可以使用逻辑视图+视图解析器返回jsp页面  通过带前缀的物理视图返回html页面
     */

    //逻辑视图：只写视图名称  需要配置视图解析器一起工作
    @RequestMapping("/sayHi03")
    public String sayHi03(){
        System.out.println("Hello SpringMVC");
        return "success";
    }
}
