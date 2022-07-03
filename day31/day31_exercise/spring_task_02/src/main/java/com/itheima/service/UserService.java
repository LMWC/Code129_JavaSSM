package com.itheima.service;

import com.itheima.domain.User;

/**
 * 用户信息维护Service
 */
public interface UserService {
    /**
     * 获取用户信息
     * @return
     */
    public User findUser();
}
