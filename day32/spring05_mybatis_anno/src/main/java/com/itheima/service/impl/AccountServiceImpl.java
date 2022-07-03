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

    @Override
    public List<Account> selectAll() {
        return accountDao.selectAll();
    }

    @Override
    public int save(Account account) { return accountDao.save(account); }

    @Override
    public Account selectById(Integer id) { return accountDao.selectById(id); }

    @Override
    public int update(Account account) { return accountDao.update(account); }

    @Override
    public int deleteById(Integer id) { return accountDao.deleteById(id); }

    //初步整合
    /*@Override
    public List<Account> selectAll() {

        List<Account> list = null;

        try {
            //1.加载mybatis的配置文件
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

            //2.获取SqlSessionFactory对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

            //3.获取SqlSession对象
            SqlSession sqlSession = sqlSessionFactory.openSession();

            //4.获取AccountDao接口代理对象
            AccountDao accountDao = sqlSession.getMapper(AccountDao.class);

            //5.调用方法
            list = accountDao.selectAll();

            //6.关闭SqlSession
            sqlSession.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }*/
}
