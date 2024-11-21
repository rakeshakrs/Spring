package com.example.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;
@Aspect
@Order(2)
@Component
public class LoggerAspect {

    private final Logger logger=Logger.getLogger(LoggerAspect.class.getName());

    @Around("execution(* com.example.services.*.*(..))")
    public void log(ProceedingJoinPoint joinPoint) throws Throwable{
        logger.info(joinPoint.getSignature().toString()+" Method execution starts");
        Instant start=Instant.now();
        joinPoint.proceed();
        Instant end=Instant.now();
        long duration= Duration.between(start,end).toMillis();
        logger.info("time taken for execution "+duration);
        logger.info(joinPoint.getSignature().toString()+" Method execution ends");

    }

    @Around("@annotation(com.example.interfaces.LogAspect)")
    public void logWithAnnotation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info((proceedingJoinPoint.getSignature().toString()+" Method execution starts"));
        Instant start=Instant.now();
        proceedingJoinPoint.proceed();
        Instant end=Instant.now();
        long duration=Duration.between(start,end).toMillis();
        logger.info("time taken for execution "+duration);
        logger.info(proceedingJoinPoint.getSignature().toString()+" Method execution ends");
    }

    @AfterThrowing(value="execution(* com.example.services.*.*(..))",throwing="ex")
    public void logException(JoinPoint joinPoint,Exception ex){
        logger.log(Level.SEVERE, joinPoint.getSignature()+" Method throws exception with help of afterthrow "+ex.getMessage());
    }

    @AfterReturning(value="execution(* com.example.services.*.*(..))",returning="retValue")
    public void logSuccess(JoinPoint joinPoint,Object retValue){
        logger.log(Level.INFO,joinPoint.getSignature()+"Method completed successfully with returning value as "+retValue.toString());
    }
}
