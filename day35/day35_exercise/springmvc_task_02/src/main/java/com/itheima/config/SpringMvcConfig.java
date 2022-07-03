package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//TODO:添加配置类注解
@Configuration
//TODO:设置扫描controller与config的包路径
@ComponentScan({"com.itheima.controller","com.itheima.config"})
//TODO:开启SpringMVC的注解驱动
@EnableWebMvc
public class SpringMvcConfig {

}
