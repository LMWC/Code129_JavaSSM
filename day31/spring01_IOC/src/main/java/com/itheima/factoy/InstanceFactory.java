package com.itheima.factoy;

import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;

/**
 * 实例工厂类：
 *  提供一个获取对象的实例方法
 */
public class InstanceFactory {
    public UserService getInstance(){
        System.out.println("使用实例工厂创建UserServiceImpl类的对象");
        return new UserServiceImpl();
    }
}
