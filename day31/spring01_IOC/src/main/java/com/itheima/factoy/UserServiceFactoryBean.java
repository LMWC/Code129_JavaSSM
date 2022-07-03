package com.itheima.factoy;

import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import org.springframework.beans.factory.FactoryBean;

public class UserServiceFactoryBean implements FactoryBean<UserService> {
    @Override
    public UserService getObject() throws Exception {
        System.out.println("调用了UserServiceFactoryBean实例工厂创建UserServiceImpl类对象");
        return new UserServiceImpl();
    }

    //无需设置  如果你想设置 设置为UserService.class就可以了
    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
