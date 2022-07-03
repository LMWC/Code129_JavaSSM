package com.itheima.dao;

import com.itheima.bean.Account;

import java.util.List;

public interface AccountDao {

    //查询账户列表信息
    List<Account> selectAll();

    //新增账户
    int save(Account account);

    //根据ID查询
    Account selectById(Integer id);

    //修改账户
    int update(Account account);

    //删除账户
    int deleteById(Integer id);
}
