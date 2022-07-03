package com.itheima.controller;

import com.itheima.bean.Enterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/*
    方式三：使用自定义对象封装读取application.yml配置文件中的数据     【推荐】
        使用步骤：
            1.自定义一个类  类中属性名称要和yml配置文件中属性名称保持一致
            2.类上打上@Component 、@ConfigurationProperties(prefix = "enterprise")
                prefix属性：要和配置文件中属性的父层级保持一致
            3.具体使用：哪些需要使用到配置文件的数据  就将自定义的对象注入过去就可以了
        注意：
            1.要读取的数据 需要有一个统一的前缀

 */
@RequestMapping("/books03")
@RestController
public class BookController03 {

    @Autowired
    private Enterprise enterprise;

    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Autowired
    private Environment env;

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id){
        System.out.println("id="+id);


        System.out.println("enterpriseName = " + enterprise.getName());
        System.out.println("subject[] = " + Arrays.toString(enterprise.getSubject()));
        System.out.println("====================JDBC配置信息=================");
        System.out.println("url = " + url);
        System.out.println("username = " + username);
        System.out.println("password = " + password);

        return "get success";
    }
}
