package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
public class UserController {

    @RequestMapping("/add")
    public void add(){
        System.out.println("user add ...");
    }
}
