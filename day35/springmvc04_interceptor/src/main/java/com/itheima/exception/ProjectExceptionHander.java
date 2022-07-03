package com.itheima.exception;

import com.itheima.bean.Result;
import com.itheima.constants.Code;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
public class ProjectExceptionHander {

    @ExceptionHandler(BusinessException.class)
    public Result doBuinessException(BusinessException e){
        //处理业务异常
        e.printStackTrace();
        //规范用户操作行为习惯 进行提示
        return new Result(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException e){
        //处理系统异常
        e.printStackTrace();
        //1.安抚用户
        //2.提醒运维人员排查
        //3.记录日志
        return new Result(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result doException(Exception e){
        //处理其他异常
        e.printStackTrace();
        //1.安抚用户
        //2.提醒运维人员排查
        //3.记录日志
        return new Result(Code.UNKOWN_ERR,e.getMessage());
    }
}
