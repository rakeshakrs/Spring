package com.example.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Order(1)
@Component
public class CheckVehicleStartedAspect {
    private final Logger logger= Logger.getLogger(CheckVehicleStartedAspect.class.getName());

    @Before("execution(* com.example.services.*.*(..)) && args(vehicleStarted,..)")
    public void isVehicleOn(JoinPoint jointPoint, boolean vehicleStarted){
        if(!vehicleStarted){
            throw new RuntimeException("Vehicle not started");
        }

    }
}
