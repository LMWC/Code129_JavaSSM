package com.itheima.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/*
    增强类：增强【共性】代码方法所在的类
 */
//@Component
//@Aspect
public class MyAdvice {

    @Pointcut("execution(* com.itheima..*.*(..))")
    public void pt(){}


    public void print(){
        System.out.println("打印日志~~~");
    }

    /*================前置增强代码==============*/
    //@Before("pt()")
    public void before(){
        //人为模拟异常
        //int i = 1/0;
        System.out.println("===前置增强===");
    }

    /*================后置增强代码==============*/
    //@AfterReturning("pt()")
    public void afterReturning(){
        System.out.println("===后置增强===");
    }

    /*================异常抛出后增强代码==============*/
    //@AfterThrowing("pt()")
    public void afterThrowing(){
        System.out.println("===异常抛出后增强===");
    }

    /*================最终增强代码==============*/
    //@After("pt()")
    public void after(){
        System.out.println("===最终增强===");
    }

    /*================环绕增强代码==============*/

    //@Around("pt()")
    public Object around(ProceedingJoinPoint pjp){
        System.out.println("===环绕增强===");
        Object result = null;
        try{
            //前置增强
            before();
            //1.获取目标方法原始参数
            Object[] args = pjp.getArgs();
            //1.1:修改目标方法原始参数
            args[0] = 100;
            //1.2:获取当前执行的方法名
            String name = pjp.getSignature().getName();
            System.out.println("目标方法名称：name = " + name);
            //1.3：获取当前执行的方法所属的类或接口
            //String className = pjp.getTarget().getClass().getSimpleName();
            String className = pjp.getTarget().getClass().getName();
            System.out.println("目标方法所在的类或接口名称：className = " + className);


            //执行目标方法  放行    result：目标方法执行后的返回值  如果目标方法返回值类型为void 则返回null
            result = pjp.proceed(args);
            //后置增强
            afterReturning();
        }catch (Exception e){
            //异常抛出增强
            afterThrowing();
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            //最终增强
            after();
        }

        //2.修改方法返回值
        result = "OJBK";
        return result;
    }


}
