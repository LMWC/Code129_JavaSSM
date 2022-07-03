package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;

public class UserServiceImpl implements UserService {

    //username属性  我希望Spring创建UserServiceImpl类对象的同时为username属性赋值
    private String username;

    private String address;

    private UserDao userDao;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add() {
        System.out.println("调用了UserServiceImpl的add方法~~~ "+username+" "+address);
        userDao.add();
    }
}
