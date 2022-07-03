package com.itheima.controller;


import com.itheima.bean.User;
import com.itheima.service.IUserService;
import com.itheima.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shuaige
 * @since 2022-06-06
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id){
        System.out.println("user getById id="+id);
        return userService.getById(id);
    }

}

