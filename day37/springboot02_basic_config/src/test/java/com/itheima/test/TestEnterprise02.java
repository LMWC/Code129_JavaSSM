package com.itheima.test;

import com.itheima.bean.Enterprise;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/*
    @SpringBootTest:测试类注解 打在测试类上
        作用：加载SpringBoot程序启动类  从而可以通过SpringBoot启动类的加载完成组件扫描 加载配置类 创建好Spring工厂对象
        使用注意：
            1.如果测试类创建在和启动类同级目录或是其子目录，则无需指定要加载的启动类
            2.如果测试类不在SpringBoot启动类同级目录或其子目录下，则要指定启动类，如果不指定，则会报错，程序无法运行
 */
@SpringBootTest
public class TestEnterprise02 {

    @Autowired
    private Enterprise enterprise;

    @Test
    public void fun01(){
        System.out.println("enterprise = " + enterprise);
    }
}
