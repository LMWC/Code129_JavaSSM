package com.itheima.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Date;

@Aspect
@Component
public class FieldFillAdvice {

    @Pointcut("execution(* com.itheima.service.EquipmentService.add*(..))")
    private void pt(){}

    @Around("pt()")
    public Object fillField(ProceedingJoinPoint pjp) throws Throwable{
        //1.获取方法签名
        Signature signature = pjp.getSignature();
        if(signature instanceof MethodSignature){
            MethodSignature ms = (MethodSignature) signature;
            //2.获取方法名称
            String name = ms.getName();
            //3.获取方法的参数类型
            Class parameterType = ms.getParameterTypes()[0];
            //4.获取created与updated域
            Field created = parameterType.getDeclaredField("created");
            Field updated = parameterType.getDeclaredField("updated");
            created.setAccessible(true);
            updated.setAccessible(true);
            //5.获取方法参数中的值
            Object args = pjp.getArgs()[0];
            //6.获取参数中的created与updated的值
            Object createdVal = created.get(args);
            Object updatedVal = updated.get(args);
            //7.判断值是否为NULL,如果为NULL,则设置默认值
            if(createdVal==null){
                created.set(args,new Date());
            }
            if(updatedVal==null){
                updated.set(args,new Date());
            }
        }
        //8.执行原始方法
        return pjp.proceed(pjp.getArgs());
    }
}
