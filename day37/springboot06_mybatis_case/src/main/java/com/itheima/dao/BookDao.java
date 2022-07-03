package com.itheima.dao;

import com.itheima.bean.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookDao {

    //增加书籍
    @Insert("insert into tbl_book values(null,#{type},#{name},#{description})")
    int add(Book book);

    //删除书籍
    @Delete("delete from tbl_book where id=#{id}")
    int deleteById(int id);

    //修改书籍
    @Update("update tbl_book set type=#{type},name=#{name},description=#{description} where id=#{id}")
    int update(Book book);

    //查询单个
    @Select("select * from tbl_book where id=#{id}")
    Book getById(int id);

    //查询所有
    @Select("select * from tbl_book")
    List<Book> getAll();

}
