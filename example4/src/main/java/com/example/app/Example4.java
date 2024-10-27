package com.example.app;

import com.example.beans.Vehicle;
import com.example.config.ProductConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example4 {
    public static void main(String[] args) {

        var context=new AnnotationConfigApplicationContext(ProductConfig.class);
        Vehicle vehicle = context.getBean(Vehicle.class);
        System.out.println("Bean default vehicle1 name is "+vehicle.getName());

    }
}
