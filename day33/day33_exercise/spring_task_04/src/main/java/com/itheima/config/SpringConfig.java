package com.itheima.config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.itheima")
@PropertySource("classpath:jdbc.properties")
@Import({JdbcConfig.class,MybatisConfig.class})
//TODO:开启Spring注解式事务驱动
@EnableTransactionManagement
//TODO:开启注解格式AOP功能
@EnableAspectJAutoProxy
public class SpringConfig {
}
