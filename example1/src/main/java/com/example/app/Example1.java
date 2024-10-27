package com.example.app;

import com.example.beans.Vehicle;
import com.example.config.ProductConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example1 {
    public static void main(String[] args) {
        Vehicle vehicle=new Vehicle();
        vehicle.setName("hard coded vehicle");
        System.out.println("Non bean vehicle name is "+vehicle.getName());

        var context=new AnnotationConfigApplicationContext(ProductConfig.class);
        Vehicle beanVehicle = context.getBean(Vehicle.class);
        System.out.println("Bean vehicle name is "+beanVehicle.getName());
        System.out.println(context.getBean(String.class));
        System.out.println(context.getBean(Integer.class));
    }
}
