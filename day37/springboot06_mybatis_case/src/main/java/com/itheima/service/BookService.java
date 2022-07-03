package com.itheima.service;

import com.itheima.bean.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface BookService {
    //增加书籍
    int add(Book book);

    //删除书籍
    int deleteById(int id);

    //修改书籍
    int update(Book book);

    //查询单个
    Book getById(int id);

    //查询所有
    List<Book> getAll();
}
