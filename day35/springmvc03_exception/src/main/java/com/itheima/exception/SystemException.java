package com.itheima.exception;

/**
 * 自定义系统异常类
 */
public class SystemException extends RuntimeException{
    private Integer code; //扩展属性 异常状态码

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public SystemException(){}


    public SystemException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
