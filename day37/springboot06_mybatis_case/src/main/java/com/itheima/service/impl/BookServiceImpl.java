package com.itheima.service.impl;

import com.itheima.bean.Book;
import com.itheima.dao.BookDao;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public int add(Book book) {
        return bookDao.add(book);
    }

    @Override
    public int deleteById(int id) {
        return bookDao.deleteById(id);
    }

    @Override
    public int update(Book book) {
        return bookDao.update(book);
    }

    @Override
    public Book getById(int id) {
        return bookDao.getById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }
}
