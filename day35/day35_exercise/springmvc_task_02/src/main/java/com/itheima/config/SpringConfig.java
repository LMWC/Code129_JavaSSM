package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//TODO:添加配置类注解
@Configuration
//TODO:设置扫描service的包路径
@ComponentScan("com.itheima.service")
//TODO:读取jdbc.properties配置文件
@PropertySource("classpath:jdbc.properties")
//TODO:引入JdbcConfig与MybatisConfig配置类
@Import({JdbcConfig.class,MybatisConfig.class})
//TODO:开启spring的事务管理器
@EnableTransactionManagement
public class SpringConfig {

}