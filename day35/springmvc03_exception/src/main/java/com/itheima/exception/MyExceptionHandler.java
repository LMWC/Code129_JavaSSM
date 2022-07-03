package com.itheima.exception;

import com.itheima.bean.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
 * 异常处理器 ：在项目中统一集中处理异常
    @RestControllerAdvice：打在异常处理的增强类上，对Rest风格实现Controller类进行增强
            等价于：@ControllerAdvice+@ResponseBody ==》@Component+@ResponseBody
    @ExceptionHandler：打在方法上  捕获到指定异常进入该方法处理 同一个方法可以处理多种类型的异常
 */
//@RestControllerAdvice
public class MyExceptionHandler {

    //@ExceptionHandler(Exception.class)
    public Result doException(Exception e){
        System.out.println("异常信息： " + e.getMessage());
        return  new Result(666,"请不要以你的技术挑战我的耐性！");
    }
}
