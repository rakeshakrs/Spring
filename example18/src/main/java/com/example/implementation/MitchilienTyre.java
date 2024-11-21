package com.example.implementation;

import com.example.interfaces.Tyres;
import org.springframework.stereotype.Component;

@Component
public class MitchilienTyre implements Tyres {
    @Override
    public String moveVehicle() {
        return "Mitchilien tyre moves ";

    }
}
