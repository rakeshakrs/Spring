package com.example.config;

import com.example.beans.Person;
import com.example.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "com.example.beans")
public class ProductConfig {

    @Bean
    public Vehicle vehicle(){
        Vehicle vehicle=new Vehicle();
        vehicle.setName("Vehicle1");
        return vehicle;
    }

    @Bean
    public Person person(Vehicle vehicle){
        Person person=new Person();
        person.setName("Person1");
        person.setVehicle(vehicle);
        return person;
    }

}
