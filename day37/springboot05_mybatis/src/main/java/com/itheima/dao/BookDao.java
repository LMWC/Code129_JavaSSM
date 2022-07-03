package com.itheima.dao;

import com.itheima.bean.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookDao {

    //@Select("select * from tbl_book where id=#{id}")
    Book getById(int id);

}
