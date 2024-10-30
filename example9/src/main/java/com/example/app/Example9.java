package com.example.app;

import com.example.beans.Person;
import com.example.beans.Vehicle;
import com.example.config.ProductConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;
import java.util.function.Supplier;

public class Example9 {
    public static void main(String[] args) {

        var context= new AnnotationConfigApplicationContext(ProductConfig.class);
        Vehicle vehicle = context.getBean("vehicle", Vehicle.class);
        Person person = context.getBean("person", Person.class);
        System.out.println(vehicle.getName());
        System.out.println(person.getName());

    }
}
