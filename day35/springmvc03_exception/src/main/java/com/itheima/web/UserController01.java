package com.itheima.web;

import com.itheima.bean.Result;
import com.itheima.bean.User;
import com.itheima.constants.Code;
import com.itheima.exception.BusinessException;
import com.itheima.exception.SystemException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("/users")
@RestController
public class UserController01 {

    //增加：/users + post
    @PostMapping
    public Result save(@RequestBody User user){
        System.out.println("UserController02...");
        System.out.println("add user = " + user);
        return new Result(Code.SAVE_OK,true);
    }

    //删除：/users/{id} + delete
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        System.out.println("delete user = " + id);
        return new Result(Code.DELETE_OK,true);
    }

    //修改：/users + put
    @PutMapping
    public Result update(@RequestBody User user){
        System.out.println("UserController02...");
        System.out.println("update user = " + user);
        return new Result(Code.UPDATE_OK,true);
    }


    //查询所有：/users + get
    @GetMapping
    public Result getAll(){
        System.out.println("getAll user");

        User user1 = new User(1, "zs", 18);
        User user2 = new User(2, "ls", 28);
        User user3 = new User(3, "ww", 38);

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);


        return list==null?new Result(Code.GETALL_ERR,"查询失败 请重试"):new Result(Code.GETALL_OK,list);
    }


    //查询单个：/users/{id} + get
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        System.out.println("getById user = " + id);
        User user = new User(1, "zs", 18);

        //人为异常
        //int i = 1/0;

        //模拟产生不同的异常
        //id为2：产生业务异常   BusinessException
        if(id==2){
            throw  new BusinessException(Code.BUSINESS_ERR,"用户id不存在");
        }else if(id==3){
            //id为3：产生系统异常   SystemException
            throw  new SystemException(Code.SYSTEM_ERR,"系统异常");
        }else if(id==4){
            //id为4：产生其他异常   Exception
            throw new RuntimeException("未知异常！");
        }

        return user==null?new Result(Code.GETBYID_ERR,"查询失败 请重试"):new Result(Code.GETBYID_OK,user);
    }


}
