package com.example.implementation;

import com.example.interfaces.Tyres;
import org.springframework.stereotype.Component;

@Component
public class MitchilienTyre implements Tyres {
    @Override
    public void moveVehicle() {
        System.out.println("Mitchilien tyre moves ");
    }
}
