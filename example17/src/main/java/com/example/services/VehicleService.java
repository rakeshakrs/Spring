package com.example.services;

import com.example.beans.Song;
import com.example.interfaces.MusicSystem;
import com.example.interfaces.Tyres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class VehicleService {
    private final Tyres tyres;
    private final MusicSystem musicSystem;
    public  Logger logger=Logger.getLogger(VehicleService.class.getName());

    @Autowired
    public VehicleService(Tyres tyres, MusicSystem musicSystem) {
        this.tyres = tyres;
        this.musicSystem = musicSystem;
    }

    public String makeSound(boolean vehicleStarted, Song song){
        Instant start=Instant.now();
        logger.info("Make sound method started");
        String music=null;
        if(vehicleStarted) {
            music=musicSystem.playMusic(song.getTitle(), song.getSingerName());
        }
        else{
            logger.log(Level.SEVERE,"Vehicle not started");
        }
        logger.info("Make sound method ends");
        Instant end=Instant.now();
        long duration= Duration.between(start,end).toMillis();
        logger.info("Time taken for method is "+duration);
        return music;
    }
    public String moveVehicle(boolean vehicleStarted){
        Instant start=Instant.now();
        logger.info("Move vehicle method starts");
        String isrunning=null;
        if(vehicleStarted){
            isrunning=tyres.moveVehicle();
        }
        else{
            logger.log(Level.SEVERE,"Vehicle not started");
        }
        logger.info("Move vehicle method ends");
        Instant end=Instant.now();
        long duration=Duration.between(start,end).toMillis();
        logger.info("Time take for move vehicle to finish is "+duration);
        return isrunning;

    }

    public Tyres getTyres() {
        return tyres;
    }

    public MusicSystem getMusicSystem() {
        return musicSystem;
    }
}
