package com.itheima.test;

import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserServiceImpl {

    @Test
    public void testAdd(){
        //1.创建Spring工厂对象
        //ApplicationContext context = new ClassPathXmlApplicationContext("spring-service.xml","spring-dao.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-service.xml");


        //2.找工厂要对象
        UserService us = (UserService) context.getBean("us");

        //3.对象调用方法
        us.add();

    }


    @Test
    public void testGetBean(){
        //1.创建Spring工厂对象
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-service.xml");


        //2.找工厂要对象

        //方式一：根据bean的id或name获取bean对象  需要进行强转
        //UserService us = (UserService) context.getBean("us");

        //方式二：根据bean的id和类型获取bean对象  太麻烦
        //UserService us = context.getBean("us", UserService.class);

        //方式三：直接根据类型获取bean对象 但是此时要求相同类型下只能存在一个对象
        //使用实现类类型 没问题
        //UserServiceImpl us = context.getBean(UserServiceImpl.class);
        //使用接口类型  【推荐使用接口类型】
        UserService us = context.getBean(UserService.class);


        //3.对象调用方法
        us.add();

    }

    @Test
    public void testGetBeanNames(){
        //1.创建Spring工厂对象
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-service.xml");

        //获取Spring IOC容器中 管理着的bean对象的名称数组
        String[] names = context.getBeanDefinitionNames();

        for (String name : names) {
            System.out.println("name = " + name);
        }
    }

}
