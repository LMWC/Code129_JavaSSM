package com.itheima.test;

import com.itheima.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserServiceImpl {

    //需求：使用单元测试类充当表现层调用业务层代码  调用UserServiceImpl的add方法
    //1.获取UserServiceImpl类的对象
    //2.使用UserServiceImpl类的对象调用方法
    @Test
    public void testAdd(){
        //1.创建Spring工厂对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //2.找Spring工厂要对象
        UserService us = (UserService) context.getBean("us");  //根据bean的id获取的
        //UserService us = (UserService) context.getBean("aa");  //根据bean的name获取的

        //3.对象调用方法
        us.add();

    }

    @Test
    public void testScope(){
        //1.创建Spring工厂对象
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //2.找Spring工厂要对象
        UserService us1 = (UserService) context.getBean("us");
        UserService us2 = (UserService) context.getBean("us");

        System.out.println("us1 = " + us1);
        System.out.println("us2 = " + us2);
        System.out.println("us1==us2 = " + (us1 == us2));

        //销毁Spring工厂对象
        context.close();
    }
}
