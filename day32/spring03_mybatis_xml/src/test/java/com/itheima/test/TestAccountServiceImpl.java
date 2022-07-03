package com.itheima.test;

import com.itheima.bean.Account;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestAccountServiceImpl {

    @Test
    public void testAdd(){
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
    public void testSave(){
        ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = context.getBean(AccountService.class);
        Account account = new Account();
        account.setId(4);
        account.setName("tom");
        account.setMoney(2000);
        int rst = accountService.save(account);
        System.out.println(rst);
    }

    @Test
    public void testSelectById(){
        ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = context.getBean(AccountService.class);
        Account account = accountService.selectById(4);
        System.out.println(account);
    }

    @Test
    public void testUpdate(){
        ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = context.getBean(AccountService.class);
        Account account = accountService.selectById(4);
        account.setName("jack");
        account.setMoney(3000);
        int rst = accountService.update(account);
        System.out.println(rst);
    }

    @Test
    public void testDeleteById(){
        ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = context.getBean(AccountService.class);
        int rst = accountService.deleteById(4);
        System.out.println(rst);
    }
}
