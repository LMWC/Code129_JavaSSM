package com.itheima.web;

import com.itheima.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
/*
    @RequestParam、@RequestBody、@PathVariable
        区别
            @RequestParam用于接收url地址传参或表单传参
            @RequestBody用于接收json数据
            @PathVariable用于接收路径参数，使用{参数名称}描述路径参数
        应用
            后期开发中，发送请求参数超过1个时，以json格式为主，@RequestBody应用较广
            如果发送非json格式数据，选用@RequestParam接收请求参数
            采用RESTful进行开发，当参数数量较少时，例如1个，可以采用@PathVariable接收请求路径变量，通常用于传递id值

 */
//@Controller
public class UserController01 {

    //增加：/users + post
    @ResponseBody
    //@RequestMapping(value = "/users",method = RequestMethod.POST)
    public String save(@RequestBody User user){
        System.out.println("add user = " + user);
        return "add success";
    }

    //删除：/users/{id} + delete
    @ResponseBody
    //@RequestMapping(value = "/users/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id){
        System.out.println("delete user = " + id);
        return "delete success";
    }

    //修改：/users + put
    @ResponseBody
    //@RequestMapping(value = "/users",method = RequestMethod.PUT)
    public String update(@RequestBody User user){
        System.out.println("update user = " + user);
        return "update success";
    }


    //查询所有：/users + get
    @ResponseBody
    //@RequestMapping(value = "/users",method = RequestMethod.GET)
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
    @ResponseBody
    @RequestMapping(value = "/users/{id}",method = RequestMethod.GET)
    public User getById(@PathVariable Integer id){
        System.out.println("getById user = " + id);
        User user = new User(1, "zs", 18);

        return user;
    }


}
