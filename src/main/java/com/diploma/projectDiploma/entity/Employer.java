package com.diploma.projectDiploma.entity;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document("Employer")
public class Employer {

    private String name;

    private String surname;

    private String email;

    private String phone;

    private String nameOfCompany;

    private String address;

    private String password;

    private Set<String> roles;

}
