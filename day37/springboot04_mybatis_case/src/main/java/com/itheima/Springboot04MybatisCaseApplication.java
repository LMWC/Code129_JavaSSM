package com.itheima;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.itheima.dao")
@SpringBootApplication
public class Springboot04MybatisCaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot04MybatisCaseApplication.class, args);
    }

}
