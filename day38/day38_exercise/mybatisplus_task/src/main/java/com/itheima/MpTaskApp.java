package com.itheima;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.itheima.mapper") //指定扫描Mapper接口的包路径
public class MpTaskApp {
    public static void main(String[] args) {
        SpringApplication.run(MpTaskApp.class, args);
    }
}
