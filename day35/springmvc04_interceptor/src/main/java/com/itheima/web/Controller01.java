package com.itheima.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Controller01 {

    @ResponseBody
    @RequestMapping("/show")
    public String show(){
        //int i = 1/0;
        System.out.println("调用了Controller类中的show方法...");
        return "show";
    }

    @ResponseBody
    @RequestMapping("/show01")
    public String show01(){
        System.out.println("调用了Controller类中的show01方法...");
        return "show01";
    }

    @ResponseBody
    @RequestMapping("/show02")
    public String show02(){
        System.out.println("调用了Controller类中的show02方法...");
        return "show02";
    }
}
