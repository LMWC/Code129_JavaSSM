package com.itheima.dao;

import com.itheima.domain.User;

public interface UserDao {
    /**
     * 查询用户信息
     * @return
     */
    public User queryUser();
}
