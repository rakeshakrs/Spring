package com.example.beans;

import org.springframework.stereotype.Component;

@Component
public class Vehicle1 {
    private String name="Vehicle1";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
