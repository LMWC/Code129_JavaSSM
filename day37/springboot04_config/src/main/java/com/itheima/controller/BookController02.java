package com.itheima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    方式二：使用Environment对象读取application.yml配置文件中的数据
        使用步骤：
            1.注入Environment对象
            2.使用Environment对象的getProperty("key")获取指定key的值
        注意：使用Environment对象获取yml配置文件中的简单类型数据没有问题，获取数组中的元素也是需要一个一个获取  如果直接获取返回null
 */
@RequestMapping("/books02")
@RestController
public class BookController02 {

    @Autowired
    private Environment env;

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id){
        System.out.println("id="+id);


        System.out.println("lesson = " + env.getProperty("lesson"));
        System.out.println("enterpriseName = " + env.getProperty("enterprise.name"));
        System.out.println("subject = " + env.getProperty("enterprise.subject[0]"));
        System.out.println("subject[] = " + env.getProperty("enterprise.subject"));

        return "get success";
    }
}
