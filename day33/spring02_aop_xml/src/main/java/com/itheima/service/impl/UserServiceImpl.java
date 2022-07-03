package com.itheima.service.impl;

import com.itheima.service.UserService;

/*
    AOP入门程序步骤：
        1.创建项目添加依赖  aspectjweaver
        2.抽取共性功能写到一个方法中 放到一个类中
        3.配置要增强的目标方法所在类的对象和增强类的对象 交个Spring IOC容器管理
        4.AOP配置  将增强代码所在的方法怼到目标方法中
 */
public class UserServiceImpl implements UserService {

    @Override
    public void add() {
        System.out.println("调用了UserServiceImpl的add方法~~~");
    }

    @Override
    public void update() {
        System.out.println("调用了UserServiceImpl的update方法~~~");
    }

    @Override
    public String delete(int id) {
        System.out.println("调用了UserServiceImpl的delete方法~~~ 参数：id="+id);
        return "OK";
    }
}
