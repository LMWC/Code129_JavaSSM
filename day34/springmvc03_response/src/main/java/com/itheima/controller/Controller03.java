package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
    响应文本数据:
        方式一：使用response对象直接响应
        方式二：在方法上打上@ResponseBody注解 此时就会将方法返回值作为字符串响应出去

    注意：
        1.SpringMVC中视图的跳转默认使用请求转发
 */
@Controller
public class Controller03 {

    //方式一：
    @RequestMapping("/page09")
    public void page09(HttpServletResponse response) throws IOException {
        System.out.println("page09....");
        //response.getWriter().print("Hello SZ128");

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("中文1");
    }

    //方式二：   produces = "text/html;charset=UTF-8":相当于response.setContentType("text/html;charset=UTF-8"); 用于服务器告诉浏览器我响应给你的内容类型
    @ResponseBody
    @RequestMapping(value = "/page10",produces = "text/html;charset=UTF-8")
    public String page10(){
        System.out.println("page10....");
        //return "Hello SZ129";
        return "中文2";
    }
}
