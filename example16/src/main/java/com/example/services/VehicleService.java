package com.example.services;

import com.example.interfaces.MusicSystem;
import com.example.interfaces.Tyres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class VehicleService {
    private final Tyres tyres;
    private final MusicSystem musicSystem;

    @Autowired
    public VehicleService(Tyres tyres, MusicSystem musicSystem) {
        System.out.println("Vehicles services instantiated");
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
