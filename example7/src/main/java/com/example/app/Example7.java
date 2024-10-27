package com.example.app;

import com.example.beans.Vehicle;
import com.example.config.ProductConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;
import java.util.function.Supplier;

public class Example7 {
    public static void main(String[] args) {

        Supplier<Vehicle> vehicle1Supplier = () -> {
            Vehicle vehicle1=new Vehicle();
            vehicle1.setName("Vehicle1");
            return vehicle1;
        };

        Supplier<Vehicle> vehicle2Supplier= ()->{
          Vehicle vehicle2=new Vehicle();
          vehicle2.setName("Vehicle2");
          return vehicle2;
        };

        Random random =new Random();
        int randomInt=random.nextInt();
        System.out.println("Random number is "+randomInt);

        var context = new AnnotationConfigApplicationContext(ProductConfig.class);
        if((randomInt%2)==0){
            context.registerBean("vehicle1", Vehicle.class,vehicle1Supplier);
        }
        else{
            context.registerBean("vehicle2", Vehicle.class,vehicle2Supplier);
        }
        Vehicle vehicle1=null;
        Vehicle vehicle2=null;

        try{
            vehicle1=context.getBean("vehicle1",Vehicle.class);
        }catch(NoSuchBeanDefinitionException e){
            System.out.println("Error while creating vehicle 1" + e.getMessage());
        }
        try{
            vehicle2=context.getBean("vehicle2",Vehicle.class);
        }catch(NoSuchBeanDefinitionException e){
            System.out.println("Error while creating vehicle 2" + e.getMessage());
        }

        if(vehicle1!=null){
            System.out.println("vehicle1 name is "+vehicle1.getName());
        }else{
            System.out.println("vehicle2 name is "+vehicle2.getName());
        }


    }
}
