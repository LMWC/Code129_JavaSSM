package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/brand")
@Controller
public class BrandController {

    @RequestMapping("/add")
    public void add(){
        System.out.println("brand add ...");
    }
}
