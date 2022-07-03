package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
    响应视图:
        物理视图：写一个完整视图路径  受视图解析器影响          写起来麻烦，看起来直观
        逻辑视图：写一个视图名称     配合视图解析器一起使用      写起来简单，看起来不直观
        带前缀的物理视图：不受视图解析器影响
            请求转发："forward:/success.jsp"
            重定向："redirect:/success.jsp"

    注意：
        1.SpringMVC中视图的跳转默认使用请求转发
 */
@Controller
public class Controller01 {

    //物理视图
    @RequestMapping("/page01")
    public String page01(){
        System.out.println("page01....");
        return "/success.jsp";
    }

    //逻辑视图
    @RequestMapping("/page02")
    public String page02(){
        System.out.println("page02....");
        return "success";
    }

    //带前缀的物理视图
    @RequestMapping("/page03")
    public String page03(){
        System.out.println("page03....");
        return "forward:/success.jsp";
    }

    //带前缀的物理视图
    @RequestMapping("/page04")
    public String page04(){
        System.out.println("page04....");
        return "redirect:/success.jsp";
    }

}
