package com.itheima.constants;

public interface Code {
    Integer SAVE_OK = 20011;
    Integer DELETE_OK = 20021;
    Integer UPDATE_OK = 20031;
    Integer GETBYID_OK = 20041;
    Integer GETALL_OK = 20051;

    Integer SAVE_ERR = 20010;
    Integer DELETE_ERR = 20020;
    Integer UPDATE_ERR = 20030;
    Integer GETBYID_ERR = 20040;
    Integer GETALL_ERR = 20050;

    //异常状态码
    Integer BUSINESS_ERR = 10000;
    Integer SYSTEM_ERR = 20000;
    Integer UNKOWN_ERR = 30000;
}
