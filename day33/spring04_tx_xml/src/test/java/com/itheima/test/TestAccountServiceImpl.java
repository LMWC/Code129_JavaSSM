package com.itheima.test;

import com.itheima.bean.Account;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestAccountServiceImpl {

    @Test
    public void testSelectAll(){
        //1.创建Spring工厂对象
        ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");

        //2.找工厂要对象
        AccountService accountService = context.getBean(AccountService.class);

        //3.调用方法
        List<Account> list = accountService.selectAll();
        for (Account account : list) {
            System.out.println("account = " + account);
        }
    }

    @Test
    public void testTransfer(){
        //1.创建Spring工厂对象
        ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");

        //2.找工厂要对象
        AccountService accountService = context.getBean(AccountService.class);

        //3.调用方法
        boolean flag = accountService.transfer("zs", "ls", 200);
        System.out.println("flag = " + flag);
    }
}
