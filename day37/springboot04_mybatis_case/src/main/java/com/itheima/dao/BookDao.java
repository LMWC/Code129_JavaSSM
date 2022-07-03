package com.itheima.dao;

import com.itheima.bean.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Mapper
public interface BookDao {

    //增加图书
    @Insert("insert into tbl_book values(null,#{type},#{name},#{description})")
    int add(Book book);

    //删除图书
    @Delete("delete from tbl_book where id=#{id}")
    int delete(Integer id);

    //修改图书
    @Update("update tbl_book set type=#{type},name=#{name},description=#{description} where id=#{id}")
    int update(Book book);

    //查询所有
    @Select("select * from tbl_book")
    List<Book> selectAll();

    //查询单个
    @Select("select * from tbl_book where id=#{id}")
    Book selectById(Integer id);
}
