package com.itheima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
    启动类：
        1.启动类生成在包【和groupid同名】下
        2.编写controller、service类所在的包要和启动类处于同级目录
        3.启动类类名可以随便起
        4.启动类 运行main方法表示启动项目
     @SpringBootApplication：打在启动类上
        @SpringBootConfiguration：@Configuration 表示当前这个启动类也是SpringBoot配置类
        @EnableAutoConfiguration：启动自动配置
        @ComponentScan：组件扫描  默认扫描启动类所在目录及其子目录下的java文件

 */
@SpringBootApplication
public class Springboot01QuickstartApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot01QuickstartApplication.class, args);
    }

}
