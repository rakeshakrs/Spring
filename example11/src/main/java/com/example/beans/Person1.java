package com.example.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person1 {

    private String name="Person1";

    private Vehicle1 vehicle;

    @Autowired
    public Person1(Vehicle1 vehicle) {
        this.vehicle = vehicle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicle1 getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle1 vehicle) {
        this.vehicle = vehicle;
    }
}
