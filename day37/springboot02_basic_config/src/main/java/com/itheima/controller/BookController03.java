package com.itheima.controller;

import com.itheima.bean.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/*
    方式三：使用自定义对象封装application.yml中指定配置数据
        实现步骤：
            1.自定义一个类，设置类中属性和配置文件中的二级属性名称要一致
            2.在类上打上@Component和@ConfigurationProperties【设置yml配置文件中一级属性名称】
            3.在指定类中，声明自定义类的对象，使用@Autowired注入，即可使用
        注意：

 */

@RequestMapping("/book03")
@RestController
public class BookController03 {

    @Autowired
    private Enterprise enterprise;

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id){
        System.out.println("getById : "+id);

        System.out.println("name = " + enterprise.getName());
        System.out.println("age = " + enterprise.getAge());
        System.out.println("tel = " + enterprise.getTel());
        System.out.println("subject = " + Arrays.toString(enterprise.getSubject()));


        return "Hello SpringBoot";
    }
}
