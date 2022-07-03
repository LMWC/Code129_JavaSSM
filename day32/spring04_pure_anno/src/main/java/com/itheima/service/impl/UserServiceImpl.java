package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource(name="userDaoImpl02")
    private UserDao userDao;

    @Value("张静")
    private String username;

    @Value("桥下")
    private String address;

    @Value("${jdbc.driverClass}")
    private String driverClass;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String user;
    @Value("${jdbc.password}")
    private String password;

    @Override
    public void add() {
        System.out.println("调用了UserServiceImpl的add方法~~~ ");
        System.out.println(username + " " + address);
        System.out.println("driverClass = " + driverClass);
        System.out.println("url = " + url);
        System.out.println("user = " + user);
        System.out.println("password = " + password);


        userDao.add();
    }
}
