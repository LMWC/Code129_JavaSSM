package com.itheima.bean;

import java.io.Serializable;

/**
 * 表现层响应数据统一格式结果封装模型类
 */
public class Result implements Serializable {
    private Integer code;   //操作类型以及操作结果
    private String msg;     //响应的提示信息
    private Object data;    //响应的真实数据【int、boolean、对象、集合】

    public Result() {
    }

    //请求处理成功的构造函数
    public Result(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    //请求处理失败的构造函数
    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
