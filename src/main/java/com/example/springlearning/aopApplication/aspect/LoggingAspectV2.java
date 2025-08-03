package com.example.springlearning.aopApplication.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Slf4j
//@Aspect
public class LoggingAspectV2 {

    @Before("allServiceMethodsPointCut()")
    public void beforeServiceMethodCall(JoinPoint joinPoint){
        log.info("Before Advice from logging aspect v2 : {}", joinPoint.getSignature());
    }

    @After("allServiceMethodsPointCut()")
    public void afterServiceMethodCall(JoinPoint joinPoint){
        log.info("After Advice from logging aspect v2 : {}", joinPoint.getSignature());
    }

    @AfterReturning(value = "allServiceMethodsPointCut()", returning = "returningObj")
    public void afterReturningServiceMethodCall(JoinPoint joinPoint, Object returningObj){
        log.info("After Returning Advice from logging aspect v2 : {}, returning object : {}", joinPoint.getSignature(), returningObj);
    }


    @AfterThrowing(value = "allServiceMethodsPointCut()")
    public void afterThrowingServiceMethodCall(JoinPoint joinPoint){
        log.info("After Throwing Advice from logging aspect v2 : {}", joinPoint.getSignature());
    }

    @Pointcut("execution(* com.example.springlearning.aopApplication.services.impl.*.*(..))")
    public void allServiceMethodsPointCut(){

    }

}
