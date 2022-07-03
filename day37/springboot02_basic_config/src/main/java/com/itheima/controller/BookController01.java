package com.itheima.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    方式一：使用@Value注解读取application.yml中的配置数据
        实现步骤：
            1.在类中定义成员变量
            2.在成员变量上打上@Value("${一级属性名.二级属性名}")注解
        注意：
            1.使用@Value注解一般或单个简单类型数据
            2.使用@Value注解不能直接获取数组数据，可以获取数组数据中的某个元素
 */
@RequestMapping("/book01")
@RestController
public class BookController01 {

    @Value("${lesson}")
    private String lesson;

    @Value("${enterprise.name}")
    private String name;

    //需求：获取第一个学科名称
    @Value("${enterprise.subject[0]}")
    private String subject;

    //@Value注解不能直接获取数组数据
    /*@Value("${enterprise.subject}")
    private String[] subjects;*/

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id){
        System.out.println("getById : "+id);

        System.out.println("lesson = " + lesson);
        System.out.println("name = " + name);
        System.out.println("subject = " + subject);
        /*System.out.println("subjects = " + subjects);*/

        return "Hello SpringBoot";
    }
}
