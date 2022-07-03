package com.itheima.factoy;

import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;

/**
 * 静态工厂
 *  提供一个获取对象的静态方法
 */
public class StaticFactory {

    public static UserService getInstance(){
        System.out.println("使用静态工厂创建UserServiceImpl类的对象");
        return new UserServiceImpl();
    }
}
