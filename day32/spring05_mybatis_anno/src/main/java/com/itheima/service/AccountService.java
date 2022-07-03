package com.itheima.service;

import com.itheima.bean.Account;

import java.util.List;

public interface AccountService {

    List<Account> selectAll();

    int save(Account account);

    Account selectById(Integer id);

    int update(Account account);

    int deleteById(Integer id);
}
