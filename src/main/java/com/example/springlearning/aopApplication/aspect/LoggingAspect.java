package com.example.springlearning.aopApplication.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

//    @Before("execution(* orderPackage(..))")
//    @Before("execution(* com.example.springlearning.aopApplication.services.impl.*.orderPackage(..)))")
    @Before("execution(* com.example.springlearning.aopApplication.services.impl.*.*(..))")
    public void beforeOrderPackage(JoinPoint joinPoint) {
        log.info("Before called from LoggingAspect signature, {}", joinPoint.getSignature());
        log.info("Before called from LoggingAspect kind, {}", joinPoint.getKind());

    }

//    @After("within(com.example.springlearning.aopApplication..*)")
    @After("within(com.example.springlearning.aopApplication.services.impl.*)")
    public void beforeServiceImplCalls(){
        log.info("Trying the after advice with within point cut");
    }


//    @Before("@annotation(org.springframework.transaction.annotation.Transactional)")
//    @Before("@annotation(com.example.springlearning.aopApplication.aspect.MyLogging)")
    @Before("test()")
    public void beforeTransactionAnnotationCalls(){
        log.info("Trying the before advice using the annotation point cut");
    }

    @Pointcut("@annotation(org.springframework.transaction.annotation.Transactional) AND within(com.example.springlearning.aopApplication..*)")
    public void test(){

    }

}
