package com.diploma.projectDiploma.entity;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Employer")
public class Employer {

    private String name;

    private String surname;

    private String email;

    private String phone;

}
