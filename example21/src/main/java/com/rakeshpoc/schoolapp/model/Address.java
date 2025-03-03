package com.rakeshpoc.schoolapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    private int addressId;
    @NotBlank
    @Size(min = 5,message = "Address1 must be at least 5 characters long")
    private String address1;
    private String address2;
    @NotBlank
    @Size(min = 5,message = "city must be at least 5 characters long")
    private String city;
    @NotBlank
    @Size(min = 5,message = "state must be at least 5 characters long")
    private String state;
    @NotBlank
    @Pattern(regexp = "(^$|[0-9]{5})",message = "Zip Code must be 5 digits")
    private int zipcode;

}
