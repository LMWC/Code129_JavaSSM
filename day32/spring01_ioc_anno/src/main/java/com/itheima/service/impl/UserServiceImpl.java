package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/*
    @Component：打在类上 一旦程序运行 Spring识别到某个类上有@Component注解就会创建该类的对象放入IOC容器管理
        以下这3个注解使用Spring提供配合项目使用三层架构开发的
            @Controller：是由@Component注解衍生出来的  打在web层类上
            @Service：是由@Component注解衍生出来的  打在service层类上
            @Repository：是由@Component注解衍生出来的  打在dao层类上
        以上四个注解就可以用于取代Spring配置文件中的bean标签。
            value属性：用于设置bean的唯一标识 也就是id值  如果没有设置 默认使用类名首字母小写作为bean的唯一标识

    @Scope注解：设置bean对象的作用范围 打在类上
        value属性：设置作用范围  singleton|prototype  默认是singleton
    @PostConstruct ：设置对象的初始化方法，用于取代init-method属性 打在方法上
    @PreDestroy：设置对象的销毁方法 用于取代destroy-method属性    打在方法上



 */
//@Component("us")

@Scope("prototype")
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add() {
        System.out.println("调用了UserServiceImpl的add方法~~~");
        userDao.add();
    }

    @PostConstruct
    public void init(){
        System.out.println("UserServiceImpl init...");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("UserServiceImpl destroy...");
    }

}
