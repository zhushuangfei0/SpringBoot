package com.hand.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Mr zhu
 */
@Aspect
@Component
public class AddAspect {
    private static Logger logger = LoggerFactory.getLogger(AddAspect.class);

    @Around("execution(* com.hand.*.Impl.*ServiceImpl.add*(..))")
    public Object addMethodAOP(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取service参数
        Object[] obj = joinPoint.getArgs();


        // 获取service返回值
        Object rvt = joinPoint.proceed(obj);
        return rvt;
    }
}
