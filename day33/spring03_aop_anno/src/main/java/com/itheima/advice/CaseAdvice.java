package com.itheima.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CaseAdvice {

    @Pointcut("execution(* com.itheima..*.*(..))")
    public void pt(){};

    @Around("pt()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {

        //获取执行的目标方法名称
        String methodName = pjp.getSignature().getName();
        //获取执行的目标方法所在的类或接口名称
        String className = pjp.getTarget().getClass().getName();

        //1.记录开始执行时间
        long s = System.currentTimeMillis();

        //2.调用业务层接口方法执行万次
        for (int i = 0; i < 10000; i++) {
            pjp.proceed();
        }

        //3.记录结束执行时间
        long e = System.currentTimeMillis();

        //4.计算时间差 得到接口万次执行时长
        System.out.println("业务层"+className+"接口"+methodName+"方法万次执行时长："+(e-s)+"ms");

        return null;

    }
}
