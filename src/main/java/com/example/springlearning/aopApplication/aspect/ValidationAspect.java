package com.example.springlearning.aopApplication.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class ValidationAspect {

    @Around("allServiceMethodsPointCut()")
    public Object validateOrderId(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
            Object args[] = proceedingJoinPoint.getArgs();
            Long orderId = (Long)args[0];

            if(orderId > 0){
                return proceedingJoinPoint.proceed();
            }

            return "OrderId cannot be less than 0";
    }

    @Around("allServiceMethodsPointCut()")
    public Object logExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Long startTime = System.currentTimeMillis();
        Object response = proceedingJoinPoint.proceed();
        Long endTIme  = System.currentTimeMillis();
        Long diff = endTIme - startTime;
        log.info("The execution time of {} is {}", proceedingJoinPoint.getSignature(), diff);
        return response;
    }


    @Pointcut("execution(* com.example.springlearning.aopApplication.services.impl.*.*(..))")
    public void allServiceMethodsPointCut(){}
}
