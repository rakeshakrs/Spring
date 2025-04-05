package com.rakeshpoc.schoolapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.rakeshpoc.schoolapp.proxy")
public class SchoolappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolappApplication.class, args);
	}

}
