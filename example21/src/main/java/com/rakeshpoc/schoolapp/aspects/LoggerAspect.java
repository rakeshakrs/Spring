package com.rakeshpoc.schoolapp.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Slf4j
@Aspect
@Component
public class LoggerAspect {

    @Around("execution(* com.rakeshpoc.schoolapp..*.*(..))")
    public Object log(ProceedingJoinPoint jointPoint) throws Throwable {
        log.info("{} method execution starts", jointPoint.getSignature().toString());
        Instant start=Instant.now();
        Object returnObj=jointPoint.proceed();
        Instant finish=Instant.now();
        long timeElapsed= Duration.between(start,finish).toMillis();
        log.info("{} taken taken for method execution",timeElapsed);
        log.info("{} method execution ends",jointPoint.getSignature().toString());
        return returnObj;
    }

    @AfterThrowing(value="execution(* com.rakeshpoc.schoolapp..*.*(..))",throwing="ex")
    public void logException(JoinPoint joinPoint,Exception ex){
        log.error(joinPoint.getSignature()+" an error occurred due to "+ex.getMessage());

    }
}
