package com.example.app;

import com.example.beans.Vehicle;
import com.example.config.ProductConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example3 {
    public static void main(String[] args) {

        var context=new AnnotationConfigApplicationContext(ProductConfig.class);
        Vehicle vehicle1 = context.getBean("Vehicle1",Vehicle.class);
        System.out.println("Bean vehicle1 name is "+vehicle1.getName());
        Vehicle vehicle2 = context.getBean("Vehicle2",Vehicle.class);
        System.out.println("Bean vehicle2 name is "+vehicle2.getName());
        Vehicle vehicle3 = context.getBean("Vehicle3",Vehicle.class);
        System.out.println("Bean vehicle3 name is "+vehicle3.getName());
    }
}
