package com.itheima.test;

import com.itheima.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext02.xml")
public class TestUserServiceImpl02 {

    @Autowired
    private UserService userService;

    @Test
    public void testAdd(){
        userService.add();
    }

    @Test
    public void testUpdate(){
        userService.update();
    }

    @Test
    public void testDelete(){

        String result = userService.delete(10);
        System.out.println("result = " + result);
    }

}
