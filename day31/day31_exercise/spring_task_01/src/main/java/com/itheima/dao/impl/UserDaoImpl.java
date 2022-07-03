package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;

public class UserDaoImpl implements UserDao {


    public User queryUser() {
        return new User(1,"TOM");
    }
}
