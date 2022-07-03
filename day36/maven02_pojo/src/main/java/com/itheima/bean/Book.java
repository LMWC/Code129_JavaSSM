package com.itheima.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
/*
    @Data:打在类上 会为实体类中的属性生成getter|setter方法、toString方法  ...
    @Getter|@Setter：
        打在类上：就为类中的所有属性生成getter|setter方法
        打在属性上：就为指定属性生成getter|setter方法
    @ToString：打在类上 可以为类中所有属性生成toString方法
        exclude属性：排除指定属性在toString方法中不进行输出  eg:@ToString(exclude = {"id","description"})
    @NoArgsConstructor：打在类上 为该类提供一个无参的构造方法
    @AllArgsConstructor：打在类上 为该类提供一个全参的构造方法  一般和@NoArgsConstructor一起使用
 */

@Data
public class Book implements Serializable {
    private Integer id;
    private String type;
    private String name;
    private String description;

    public static void main(String[] args) {
        Book book = new Book();
        book.setName("小硕硕");
        book.setType("小时");
        System.out.println("book = " + book);
    }
}
