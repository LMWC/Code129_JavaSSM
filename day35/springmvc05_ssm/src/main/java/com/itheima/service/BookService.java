package com.itheima.service;

import com.itheima.bean.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BookService {

    //增加图书
    int add(Book book);

    //删除图书
    int delete(Integer id);

    //修改图书
    int update(Book book);

    //查询所有
    List<Book> selectAll();

    //查询单个
    Book selectById(Integer id);

}
