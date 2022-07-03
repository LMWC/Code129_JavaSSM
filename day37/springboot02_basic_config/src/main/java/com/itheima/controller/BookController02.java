package com.itheima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    方式二：使用Environment对象封装application.yml中的全部配置数据
        实现步骤：
            1.在类中定义Environment类型的成员变量
            2.在成员变量上打上@Autowired注解
            3.使用Environment对象的getProperty方法获取指定配置文件属性数据
        注意：
            1.使用Environment对象可以通过属性名称获取单个简单类型数据以及数组元素，不能直接获取整个数组数据
 */
@RequestMapping("/book02")
@RestController
public class BookController02 {

    @Autowired
    private Environment  env;

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id){
        System.out.println("getById : "+id);

        System.out.println("lesson = " + env.getProperty("lesson"));
        System.out.println("name = " + env.getProperty("enterprise.name"));
        System.out.println("第二个学科：subject = " + env.getProperty("enterprise.subject[1]"));
        System.out.println("subjects = " + env.getProperty("enterprise.subject"));


        return "Hello SpringBoot";
    }
}
