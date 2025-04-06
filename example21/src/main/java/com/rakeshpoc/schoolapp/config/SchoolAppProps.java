package com.rakeshpoc.schoolapp.config;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
@Component("schoolAppProps")
@Data
//@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "schoolapp")
@Validated
public class SchoolAppProps {
    @Min(value=5, message="must be between 5 and 25")
    @Max(value=25, message="must be between 5 and 25")
    private int pageCount;
    @Size(min = 1,max=10)
    private String test;
}
