package com.itheima;

import com.itheima.bean.Enterprise;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot02BasicConfigApplicationTests {

    @Autowired
    private Enterprise enterprise;

    @Test
    void contextLoads() {
        System.out.println("Hello SpringBoot");
        System.out.println("enterprise = " + enterprise);
    }

}
