package com.itheima.service.impl;

import com.itheima.bean.Account;
import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> selectAll() {
        return accountDao.selectAll();
    }

    @Override
    public boolean transfer(String outName, String inName, int money) {

        //调用dao
        //钱减少
        int rows01 = accountDao.outMoney(outName, money);

        //人为异常
        //int i = 1/0;

        //钱增加
        int rows02 = accountDao.inMoney(inName, money);

        if(rows01>0 && rows02>0){
            return true;
        }else{
            return false;
        }
    }

}
