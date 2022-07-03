package com.itheima;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.bean.User;
import com.itheima.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class MyBatisPlusTest {

    @Autowired
    private UserDao userDao;

    //查询全部
    @Test
    public void testSelectList(){
        List<User> list = userDao.selectList(null);
        System.out.println("list = " + list);
    }

    //新增
    /*@Test
    public void testAdd(){
        User user = new User(null, "zss6", "123", "男", 12, "11010", 1);
        userDao.insert(user);
        //deleteById
        //updateById
    }*/

    //多记录操作
    @Test
    public void testMultiOpreate(){
        //1.多记录查询
        /*//1.1：准备存放多个id的list集合
        List<Long> ids = new ArrayList<>();
        ids.add(1533667898084675585L);
        ids.add(1533667898084675586L);
        ids.add(1533700169906884610L);

        //1.2:调用selectBatchIds方法
        List<User> list = userDao.selectBatchIds(ids);
        for (User user : list) {
            System.out.println("user = " + user);
        }*/

        //2.多记录删除
        //2.1：准备存放多个id的list集合
        List<Long> ids = new ArrayList<>();
        ids.add(6L);

        //2.2：调用deleteBatchIds方法
        int rows = userDao.deleteBatchIds(ids);
        System.out.println("rows = " + rows);
    }


    @Test
    public void testVersion(){
        //1.模拟两个人同时查询用户表id为3的用户信息
        User user01 = userDao.selectById(3);//zs
        User user02 = userDao.selectById(3);//ls

        //2.模拟两个人同时修改用户表id为3的用户名
        //zs先修改了
        user01.setName("张三2");
        userDao.updateById(user01);

        //ls又修改了
        user02.setName("李四2");
        userDao.updateById(user02);

    }
}
