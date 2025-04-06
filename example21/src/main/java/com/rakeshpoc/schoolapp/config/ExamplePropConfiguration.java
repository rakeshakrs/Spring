package com.rakeshpoc.schoolapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:example.properties")
public class ExamplePropConfiguration {
}
