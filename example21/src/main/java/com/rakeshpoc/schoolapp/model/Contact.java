package com.rakeshpoc.schoolapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name = "contact_msg")
public class Contact extends BaseEntity{
    @Id
    @Column(name="contact_id")
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name="native",strategy = "native")
    private int contactId;
    @NotBlank(message = "Name should not be blank")
    @Size(min = 3,message = "Name must be atleast 3 char long")
    private String name;
    @NotBlank(message = "Mobile Number should not be blank")
    @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile Number must 10 digit")
    private String mobileNum;
    @NotBlank(message = "Email should not be blank")
    @Email(message = "Enter valid email id")
    private String email;
    @NotBlank(message = "Subject should not be blank")
    @Size(min = 10,message = "Subject must be atleast 10 char long")
    private String subject;
    @NotBlank(message = "Message should not be blank")
    @Size(min = 20,message = "Message must be atleast 20 char long")
    private String message;
    private String status;
}
