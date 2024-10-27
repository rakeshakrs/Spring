package com.example.app;

import com.example.beans.Vehicle;
import com.example.config.ProductConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example2 {
    public static void main(String[] args) {

        var context=new AnnotationConfigApplicationContext(ProductConfig.class);
        Vehicle vehicle1 = context.getBean("vehicle1",Vehicle.class);
        System.out.println("Bean vehicle1 name is "+vehicle1.getName());

    }
}
