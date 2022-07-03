package com.itheima.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
    方式一：使用@Value注解读取application.yml配置文件中的数据
        注意：一般用于获取简单类型数据
 */
@RequestMapping("/books01")
@RestController
public class BookController {

    @Value("${lesson}")
    private String lesson;

    @Value("${enterprise.name}")
    private String enterpriseName;

    @Value("${enterprise.subject[1]}")
    private String subject;

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id){
        System.out.println("id="+id);


        System.out.println("lesson = " + lesson);
        System.out.println("enterpriseName = " + enterpriseName);
        System.out.println("subject = " + subject);

        return "get success";
    }
}
