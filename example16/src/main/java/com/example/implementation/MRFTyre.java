package com.example.implementation;

import com.example.interfaces.Tyres;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MRFTyre implements Tyres {
    @Override
    public void moveVehicle() {
        System.out.println("MRF tyre moves ");
    }
}
