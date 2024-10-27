package com.example.config;

import com.example.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProductConfig {

    @Bean
    Vehicle vehicle1(){
        var vehicle = new Vehicle();
        vehicle.setName("Tata Tiago 1");
        return vehicle;
    }

    @Bean
    Vehicle vehicle2(){
        var vehicle = new Vehicle();
        vehicle.setName("Tata Tiago 2");
        return vehicle;
    }
    @Primary
    @Bean
    Vehicle vehicle3(){
        var vehicle = new Vehicle();
        vehicle.setName("Tata Tiago 3");
        return vehicle;
    }
}
