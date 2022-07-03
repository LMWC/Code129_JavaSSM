package com.itheima.dao;

import org.apache.ibatis.annotations.Insert;

public interface LogDao {

    @Insert("insert into tbl_log(info) values(#{info})")
    int log(String info);
}
