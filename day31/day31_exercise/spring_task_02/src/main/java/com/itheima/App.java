package com.itheima;

import com.itheima.domain.User;
import com.itheima.service.UserService;

public class App {
    public static void main(String[] args) {
        SpringApplicationContext ctx = new SpringApplicationContext("beans.xml");
        UserService userService = (UserService)ctx.getBean("userService");
        User user = userService.findUser();
        System.out.println("查询到用户信息为:"+user);
    }
}
