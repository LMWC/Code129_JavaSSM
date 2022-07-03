package com.itheima;

import com.itheima.bean.User;
import com.itheima.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Mybatisplus01QuickstartApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
        List<User> list = userDao.selectList(null);
        for (User user : list) {
            System.out.println("user = " + user);
        }
    }

}
