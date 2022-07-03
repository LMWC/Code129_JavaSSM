package com.itheima.dao;

import com.itheima.bean.Account;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AccountDao {

    //查询账户列表信息
    List<Account> selectAll();

    //转入：钱增加
    @Update("update account set money=money+#{money} where name=#{inName}")
    int inMoney(@Param("inName") String inName,@Param("money") int money);

    //转出：钱减少
    @Update("update account set money=money-#{money} where name=#{outName}")
    int outMoney(@Param("outName") String outName,@Param("money") int money);
}
