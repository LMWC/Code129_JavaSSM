package com.itheima.test;

import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestUserServiceImpl {

    /*
        Spring如何知道你是否对某个方法进行增强了？

        Spring读取配置文件 通过切入点表达式就知道了
        注意：
            1.一旦对某个类或接口中的方法进行增强了，Spring在IOC容器中管理的就是增强后的代理对象，必须使用接口类型接收。
                即使某个方法没有进行增强，也不能使用实现类对象调用
            2.如果没有对某个类或接口中的方法进行增强，Spring在IOC容器中管理的还是原有的实现类对象。

        AOP底层采用动态代理实现，在不改变方法原有代码的基础上，增强新的功能。在使用时，通过接口类型接收目标对象即可。
     */

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
        userService.delete(10);
    }

}
