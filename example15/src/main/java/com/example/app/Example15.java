package com.example.app;

import com.example.beans.Person;
import com.example.config.ProductConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example15 {
    public static void main(String[] args) {

        var context= new AnnotationConfigApplicationContext(ProductConfig.class);
        System.out.println("Before Person bean creation");
        Person person = context.getBean( Person.class);
        System.out.println("After Person bean creation");
           }
}
