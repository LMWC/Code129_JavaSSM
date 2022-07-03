package com.itheima.service;

import com.itheima.bean.Account;

import java.util.List;

public interface AccountService {

    List<Account> selectAll();

    boolean transfer(String outName,String inName,int money);
}
