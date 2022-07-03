package com.itheima.web;

import com.itheima.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
/*
    @ResponseBody：打在类上，表示该类中的所有方法都响应json数据或文本数据。
    @RequestMapping("/users")：打在类上  为类中所有方法设置一个统一的请求地址前缀
    @RestController：打在类上 等价于 @Controller+@ResponseBody的组合
        @PostMapping：打在方法上，等价于@RequestMapping(method = RequestMethod.POST)
        @DeleteMapping("/{id}")：打在方法上，等价于@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
        @PutMapping：打在方法上，等价于@RequestMapping(method = RequestMethod.PUT)
        @GetMapping：打在方法上，等价于@RequestMapping(method = RequestMethod.GET)
 */
@RequestMapping("/users")
@RestController
public class UserController02 {

    //增加：/users + post
    @PostMapping
    public String save(@RequestBody User user){
        System.out.println("UserController02...");
        System.out.println("add user = " + user);
        return "add success";
    }

    //删除：/users/{id} + delete
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        System.out.println("delete user = " + id);
        return "delete success";
    }

    //修改：/users + put
    @PutMapping
    public String update(@RequestBody User user){
        System.out.println("UserController02...");
        System.out.println("update user = " + user);
        return "update success";
    }


    //查询所有：/users + get
    @GetMapping
    public List<User> getAll(){
        System.out.println("getAll user");

        User user1 = new User(1, "zs", 18);
        User user2 = new User(2, "ls", 28);
        User user3 = new User(3, "ww", 38);

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);


        return list;
    }


    //查询单个：/users/{id} + get
    @GetMapping("/{id}")
    public User getById(@PathVariable Integer id){
        System.out.println("getById user = " + id);
        User user = new User(1, "zs", 18);

        return user;
    }


}
