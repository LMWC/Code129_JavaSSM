package com.shuaige;

import com.itheima.SpringbootDemoApplication;
import com.itheima.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SpringbootDemoApplication.class)
public class DemoTest {

    @Autowired
    private UserService us;

    @Test
    public void test01(){
        System.out.println("Hello World!");
        us.add();
    }
}
