package com.diploma.projectDiploma.doMain;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.*;

@Data
@Document(collection = "Workers")
public class Worker {

    @Id
    private String id;

    @NotEmpty
    @Pattern(regexp = "^[A-Za-z]+$", message = "Only liters")
    @Size(min = 2, message = "min 3 letters")
    private String name;

    @NotEmpty
    @Size(min = 2)
    private String surname;

    @NotEmpty
    @Email(regexp = ".+@.+\\..+", message = "Write true email")
    private String email;

    @NotEmpty
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%&!^*]).{8,20}$", message = "bed password")
    private String pass;

    @Min(value = 0, message = "Text reality age")
    private int age;

    @Size(max = 11, message = "text right number of phone")
    private String phoneNumber;

    @NotEmpty
    private String nationality;

    @NotEmpty
    private String city;

    @NotEmpty
    private String street;

    @NotEmpty
    private String houseNumber;

    @NotEmpty
    @Size(min = 9, max = 9)
    private int PESEL;

}
