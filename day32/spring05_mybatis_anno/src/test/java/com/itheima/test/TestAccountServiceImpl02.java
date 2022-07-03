package com.itheima.test;

import com.itheima.bean.Account;
import com.itheima.config.SpringConfig;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/*
    Spring整合Junit：
        目的：为了方便进行Spring程序单元测试
        实现步骤：
            1.项目添加依赖 junit、spring-test
            2.在单元测试类上打上两个注解
                @RunWith(SpringJUnit4ClassRunner.class)：设置当前单元测试环境 表示使用Spring整合Junit的单元测试
                @ContextConfiguration：加载Spring配置文件或Spring配置类 提前创建出Spring工厂对象  在进行单元测试时，就可以直接声明注入使用了
                    eg:
                        1.加载配置类：@ContextConfiguration(classes = SpringConfig.class)
                        2.加载配置文件：@ContextConfiguration("applicationContext.xml")
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class TestAccountServiceImpl02 {

    @Autowired
    private AccountService accountService;

    @Autowired
    private ApplicationContext context;

    @Test
    public void testAdd(){

        //3.调用方法
        List<Account> list = accountService.selectAll();
        for (Account account : list) {
            System.out.println("account = " + account);
        }
    }

    @Test
    public void testGetBeans(){

        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("name = " + name);
        }
    }

    @Test
    public void testSave(){
        Account account = new Account();
        account.setId(4);
        account.setName("tom");
        account.setMoney(2000);
        int rst = accountService.save(account);
        System.out.println(rst);
    }

    @Test
    public void testSelectById(){
        Account account = accountService.selectById(4);
        System.out.println(account);
    }

    @Test
    public void testUpdate(){
        Account account = accountService.selectById(4);
        account.setName("jack");
        account.setMoney(3000);
        int rst = accountService.update(account);
        System.out.println(rst);
    }

    @Test
    public void testDeleteById(){
        int rst = accountService.deleteById(4);
        System.out.println(rst);
    }
}
