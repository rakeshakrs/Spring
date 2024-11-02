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
    public Vehicle vehicle1(){
        Vehicle vehicle1=new Vehicle();
        vehicle1.setName("vehicle1");
        return vehicle1;
    }

    @Bean
    public Vehicle vehicle2(){
        Vehicle vehicle2=new Vehicle();
        vehicle2.setName("vehicle2");
        return vehicle2;
    }

    @Bean
    @Primary
    public Vehicle vehicle3(){
        Vehicle vehicle3=new Vehicle();
        vehicle3.setName("vehicle3");
        return vehicle3;
    }

}
