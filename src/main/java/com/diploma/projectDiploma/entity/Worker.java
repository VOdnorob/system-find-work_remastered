package com.diploma.projectDiploma.entity;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.*;

import java.util.Set;

@Data
@Document(collection = "Workers")
public class Worker {

    @Id
    private String id;

    @NotEmpty
    @Pattern(regexp = "^[A-Za-z]+$", message = "Only alphabetic characters")
    private String name;

    @NotEmpty
    @Size(min = 2)
    private String surname;

    @NotEmpty
    @Email(regexp = ".+@.+\\..+", message = "Write true email")
    private String email;

    @NotEmpty(message = "Password cannot be empty")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password should contains one lower case, one upper case, special symbol and one number")
    private String password;

    @Min(value = 0, message = "Text reality age")
    private int age;

    @NotEmpty
    private String phoneNumber;

    @NotEmpty
    private String nationality;

    private String city;

    private String street;

    private String houseNumber;

    private Set<String>  roles;

    @NotEmpty
    @Size(min = 11, max = 11)
    private String pesel;

}
