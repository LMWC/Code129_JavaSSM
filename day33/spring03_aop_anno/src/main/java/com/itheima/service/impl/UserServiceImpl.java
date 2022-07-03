package com.itheima.service.impl;

import com.itheima.service.UserService;
import org.springframework.stereotype.Service;

/*
    AOP注解方式实现：
        1.在增强类和service类分别打上@Component和@Service注解
        2.在增强类上打上@Aspect注解
        3.在增强类中定义一个方法 在方法上打上@Pointcut注解 用来设置切点表达式
        4.在增强代码所在方法上打上响应的增强类型注解，绑定切入点
            @Before：前置增强
            @AfterReturning：后置增强
            @AfterThrowing：异常抛出后增强
            @After：最终增强
            @Around：环绕增强
        5.在Spring配置文件中 开启组件扫描和AOP注解驱动支持
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public void add() {
        System.out.println("调用了UserServiceImpl的add方法~~~");
    }

    @Override
    public void update() {
        System.out.println("调用了UserServiceImpl的update方法~~~");
    }

    @Override
    public String delete(int id) {
        System.out.println("调用了UserServiceImpl的delete方法~~~ 参数：id="+id);
        return "OK";
    }
}
