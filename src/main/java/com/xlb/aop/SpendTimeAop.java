package com.xlb.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class SpendTimeAop {
    @Pointcut("execution(* com.xlb.dao.*.*(..))")
    public void spendTime() {

    }

    @Around("spendTime()")
    public Object around(ProceedingJoinPoint joinPoint) {
        log.info("start spend time aop");
        Object res = null;
        long start = System.currentTimeMillis();
        try {
            res =  joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        String methodName = joinPoint.getSignature().getDeclaringType().getSimpleName() + "."+ joinPoint.getSignature().getName();
        log.info("method name: {},spend time: {} ms", methodName, end - start);
        return res;
    }
}
