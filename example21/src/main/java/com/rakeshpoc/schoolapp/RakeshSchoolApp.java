package com.rakeshpoc.schoolapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.rakeshpoc.schoolapp.repository")
@EntityScan("com.rakeshpoc.schoolapp.model")
@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
public class RakeshSchoolApp {

	public static void main(String[] args) {
		SpringApplication.run(RakeshSchoolApp.class, args);
	}

}
