package com.itheima.service.impl;

import com.itheima.domain.User;
import com.itheima.service.UserService;

public class UserServiceImpl implements UserService {

    private String username;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User findUser() {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }
}
