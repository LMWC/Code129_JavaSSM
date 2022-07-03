package com.itheima.aspect;

import com.itheima.annotation.RequiredLog;
import com.itheima.domain.SysLog;
import com.itheima.service.SysLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

@Component
@Aspect
public class SysLogAdvice {

    @Autowired
    private SysLogService sysLogService;

    @Pointcut("execution(* com.itheima.service.*Service.*(..))")
    private void lg(){}

    @Around("lg()")
    public Object addLog(ProceedingJoinPoint pjp) throws Throwable{

        //执行原有业务
        Object obj = pjp.proceed(pjp.getArgs());
        //获取类的字节码对象，通过字节码对象获取方法信息
        Class<?> clz = pjp.getTarget().getClass();
        //获取方法签名
        Signature signature = pjp.getSignature();
        if(signature instanceof MethodSignature){
            MethodSignature ms = (MethodSignature) signature;
            //获取目标方法上的注解的操作名称
            Method method = clz.getDeclaredMethod(ms.getName(), ms.getParameterTypes());
            //获取方法上的RequiredLog注解
            RequiredLog requiredLog = method.getAnnotation(RequiredLog.class);
            //判断是否有该注解
            if(requiredLog!=null){
                SysLog sysLog = new SysLog();
                String operation = requiredLog.operation();
                sysLog.setOperation(operation);
                //获取目标方法名(目标类型+方法名)
                String methodName = clz.getName()+"."+ms.getName();
                sysLog.setMethod(methodName);
                //获取请求参数
                String params = Arrays.toString(pjp.getArgs());
                sysLog.setParams(params);
                sysLog.setUsername("admin");
                sysLog.setCreated(new Date());
                sysLogService.insertLog(sysLog);
            }
        }
        return obj;
    }
}
