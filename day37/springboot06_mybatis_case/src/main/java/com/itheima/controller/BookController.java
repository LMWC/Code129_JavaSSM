package com.itheima.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.bean.Book;
import com.itheima.bean.PageParam;
import com.itheima.bean.Result;
import com.itheima.constants.Code;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@RequestMapping("/books")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    //增加书籍  /books +    post
    @PostMapping
    public Result add(@RequestBody Book book){
        System.out.println("book add...");
        //调用service处理
        int rows = bookService.add(book);

        //返回处理结果
        return rows>0?new Result(Code.SAVE_OK,true):new Result(Code.SAVE_ERR,"增加书籍失败！");
    }

    //删除书籍 /books/{id} +      delete
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        System.out.println("book delete id="+id);

        //调用service处理
        int rows = bookService.deleteById(id);

        //返回处理结果
        return rows>0?new Result(Code.DELETE_OK,true):new Result(Code.DELETE_ERR,"删除书籍失败！");
    }

    //修改书籍 /books       +   put
    @PutMapping
    public Result update(@RequestBody Book book){
        System.out.println("book update...");
        //调用service处理
        int rows = bookService.update(book);

        //返回处理结果
        return rows>0?new Result(Code.UPDATE_OK,true):new Result(Code.UPDATE_ERR,"修改书籍信息失败！");
    }


    //查询所有书籍 /books +   get
    @GetMapping
    public Result getAll(){
        System.out.println("book getAll...");

        //调用service处理
        List<Book> list = bookService.getAll();

        //返回处理结果
        return list==null?new Result(Code.GET_ALL_ERR,"查询失败，请重试！"):new Result(Code.GET_ALL_OK,list);
    }
}
