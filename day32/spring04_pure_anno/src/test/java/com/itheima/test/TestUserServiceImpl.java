package com.itheima.test;

import com.itheima.config.AppConfig;
import com.itheima.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserServiceImpl {

    @Test
    public void testAdd(){
        //1.创建Spring工厂对象 加载Spring配置类
        //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //2.找工厂要对象
        UserService userService = context.getBean(UserService.class);

        //3.调用方法
        userService.add();

    }

    @Test
    public void testGetBeans(){
        //1.创建Spring工厂对象
        //ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("name = " + name);
        }

    }

    @Test
    public void testScope() {
        //1.创建Spring工厂对象
        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        //2.从工厂要对象
        UserService us1 = context.getBean(UserService.class);
        UserService us2 = context.getBean(UserService.class);

        System.out.println("us1 = " + us1);
        System.out.println("us2 = " + us2);
        System.out.println("us1==us2 = " + (us1 == us2));

        //3.销毁Spring工厂对象
        context.close();

    }
}
