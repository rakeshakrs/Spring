package com.example.app;

import com.example.beans.Song;
import com.example.config.ProductConfig;
import com.example.services.VehicleService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example17 {
    public static void main(String[] args) {

        var context= new AnnotationConfigApplicationContext(ProductConfig.class);
        VehicleService vehicleService1=context.getBean(VehicleService.class);
        Song song=new Song();
        song.setTitle("what a song");
        song.setSingerName("Rakesh");
        vehicleService1.makeSound(true,song);
        vehicleService1.moveVehicle(true);

           }
}
