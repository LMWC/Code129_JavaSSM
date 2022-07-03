package com.itheima.exception;

/**
 * 自定义业务异常类
 */
public class BusinessException extends RuntimeException{
    private Integer code; //扩展属性 异常状态码

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public BusinessException(){}


    public BusinessException(Integer code,String message) {
        super(message);
        this.code = code;
    }
}
