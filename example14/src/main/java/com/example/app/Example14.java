package com.example.app;

import com.example.beans.Person;
import com.example.beans.Vehicle;
import com.example.config.ProductConfig;
import com.example.services.VehicleService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example14 {
    public static void main(String[] args) {

        var context= new AnnotationConfigApplicationContext(ProductConfig.class);
        Vehicle vehicle = context.getBean(Vehicle.class);
        Person person = context.getBean( Person.class);
        System.out.println(vehicle.getName());
        System.out.println(person.getName());
        person.getVehicle().getVehicleService().makeSound();
        person.getVehicle().getVehicleService().moveVehicle();
        VehicleService vehicleService1=context.getBean(VehicleService.class);
        VehicleService vehicleService2=context.getBean(VehicleService.class);
        System.out.println(vehicleService1.hashCode());
        System.out.println(vehicleService2.hashCode());

           }
}
