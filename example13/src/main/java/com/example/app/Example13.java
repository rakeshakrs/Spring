package com.example.app;

import com.example.beans.Person;
import com.example.beans.Vehicle;
import com.example.config.ProductConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example13 {
    public static void main(String[] args) {

        var context= new AnnotationConfigApplicationContext(ProductConfig.class);
        Vehicle vehicle = context.getBean(Vehicle.class);
        Person person = context.getBean( Person.class);
        System.out.println(vehicle.getName());
        System.out.println(person.getName());
        person.getVehicle().getVehicleService().makeSound();
        person.getVehicle().getVehicleService().moveVehicle();

           }
}
