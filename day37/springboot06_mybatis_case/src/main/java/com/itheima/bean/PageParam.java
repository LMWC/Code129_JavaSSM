package com.itheima.bean;

import lombok.Data;

@Data
public class PageParam {
    private Integer currentPage;
    private Integer pageSize;
    private Book book;
}
