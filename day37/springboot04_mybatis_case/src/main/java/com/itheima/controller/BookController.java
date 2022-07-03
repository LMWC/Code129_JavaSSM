package com.itheima.controller;

import com.itheima.bean.Book;
import com.itheima.bean.Result;
import com.itheima.constants.Code;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/books")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    //增加图书
    @PostMapping
    public Result add(@RequestBody Book book){
        int rows = bookService.add(book);
        return rows>0?new Result(Code.SAVE_OK,true):new Result(Code.SAVE_ERR,"增加失败！");
    }

    //删除图书
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        int rows = bookService.delete(id);
        return rows>0?new Result(Code.DELETE_OK,true):new Result(Code.DELETE_ERR,"删除失败！");
    }

    //修改图书
    @PutMapping
    public Result update(@RequestBody Book book){
        int rows = bookService.update(book);
        return rows>0?new Result(Code.UPDATE_OK,true):new Result(Code.UPDATE_ERR,"修改失败！");
    }

    //查询所有
    @GetMapping
    public Result selectAll(){
        List<Book> list = bookService.selectAll();
        return new Result(Code.GETALL_OK,list);
    }

    //查询单个
    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id){
        Book book = bookService.selectById(id);
        return new Result(Code.GETBYID_OK,book);
    }
    
}
