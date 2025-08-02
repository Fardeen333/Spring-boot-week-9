package com.example.springlearning.aopApplication.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {


    @Before("execution(* com.example.springlearning.aopApplication.services.impl.*.*(..))")
    public void beforeOrderPackage(JoinPoint joinPoint) {
        log.info("Before called from LoggingAspect signature, {}", joinPoint.getSignature());
        log.info("Before called from LoggingAspect kind, {}", joinPoint.getKind());

    }

}
