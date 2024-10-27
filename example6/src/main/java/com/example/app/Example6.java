package com.example.app;

import com.example.beans.Vehicle;
import com.example.config.ProductConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example6 {
    public static void main(String[] args) {

        var context=new AnnotationConfigApplicationContext(ProductConfig.class);
        Vehicle vehicle = context.getBean(Vehicle.class);
        System.out.println("Bean vehicle1 name is "+vehicle.getName());
        context.close();

    }
}
