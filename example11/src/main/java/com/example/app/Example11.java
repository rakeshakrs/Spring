package com.example.app;

import com.example.beans.Person;
import com.example.beans.Person1;
import com.example.beans.Vehicle;
import com.example.beans.Vehicle1;
import com.example.config.ProductConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;
import java.util.function.Supplier;

public class Example11 {
    public static void main(String[] args) {

        var context= new AnnotationConfigApplicationContext(ProductConfig.class);
        Vehicle vehicle = context.getBean("vehicle", Vehicle.class);
        Person person = context.getBean("person", Person.class);
        System.out.println(vehicle.getName());
        System.out.println(person.getName());
        System.out.println(person.getVehicle().getName());
        Vehicle1 vehicle1 = context.getBean(Vehicle1.class);
        Person1 person1 = context.getBean(Person1.class);
        System.out.println(vehicle1.getName());
        System.out.println(person1.getName());
        System.out.println(person1.getVehicle().getName());

    }
}
