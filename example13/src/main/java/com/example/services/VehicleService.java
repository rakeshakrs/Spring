package com.example.services;

import com.example.interfaces.MusicSystem;
import com.example.interfaces.Tyres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleService {
    private final Tyres tyres;
    private final MusicSystem musicSystem;

    @Autowired
    public VehicleService(Tyres tyres, MusicSystem musicSystem) {
        this.tyres = tyres;
        this.musicSystem = musicSystem;
    }

    public void makeSound(){
        musicSystem.playMusic();
    }
    public void moveVehicle(){
        tyres.moveVehicle();
    }

    public Tyres getTyres() {
        return tyres;
    }

    public MusicSystem getMusicSystem() {
        return musicSystem;
    }
}
