package com.diploma.projectDiploma.entity;


import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("Vacancy")
public class Vacancy {

    @Id
    private String id;

    private String workerId;

    @NotEmpty
    private String title;

    @NotEmpty
    private String description;

    private List<String> candidateIds;

    private boolean isAccepted = false;

}
