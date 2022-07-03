package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;

public class UserServiceImpl02 implements UserService {

    //username属性  我希望Spring创建UserServiceImpl类对象的同时为username属性赋值
    private String username;

    private String address;

    private UserDao userDao;

    public UserServiceImpl02() {
    }

    //使用构造方法为属性赋值
    public UserServiceImpl02(String username, String address, UserDao userDao) {
        this.username = username;
        this.address = address;
        this.userDao = userDao;
    }

    @Override
    public void add() {
        System.out.println("调用了UserServiceImpl的add方法~~~ "+username+" "+address);
        userDao.add();
    }
}
