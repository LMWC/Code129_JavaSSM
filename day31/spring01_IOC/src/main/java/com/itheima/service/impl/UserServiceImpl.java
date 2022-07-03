package com.itheima.service.impl;

import com.itheima.service.UserService;

public class UserServiceImpl implements UserService {

    public UserServiceImpl() {
        System.out.println("UserServiceImpl无参构造函数...");
    }

    public UserServiceImpl(String username) {
        System.out.println("UserServiceImpl有参构造函数...");
    }

    @Override
    public void add() {
        System.out.println("调用了UserServiceImpl的add方法~~~");
    }

    //初始化方法
    public void init(){
        System.out.println("UserServiceImpl init...");
    }

    //销毁方法
    public void destroy(){
        System.out.println("UserServiceImpl destroy...");
    }
}
