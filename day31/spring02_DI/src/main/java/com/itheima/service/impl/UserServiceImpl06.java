package com.itheima.service.impl;

import com.itheima.service.UserService;

import java.util.*;

public class UserServiceImpl06 implements UserService {

    private String driverClass;
    private String url;
    private String username;
    private String password;

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void add() {
        System.out.println("调用了UserServiceImpl05的add方法~~~ ");
        System.out.println("driverClass = " + driverClass);
        System.out.println("url = " + url);
        System.out.println("username = " + username);
        System.out.println("password = " + password);
    }
}
