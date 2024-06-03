package com.diploma.projectDiploma.controllers;


import com.diploma.projectDiploma.entity.Vacancy;
import com.diploma.projectDiploma.services.VacancyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employers")
public class EmployerController {


    private final VacancyService vacancyService;

    @Autowired
    public EmployerController(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @PreAuthorize("hasRole('ROLE_EMPLOYER')")
    @CrossOrigin
    @PostMapping("/createVacancy")
    public HttpStatus createVacancy(@Valid @RequestBody Vacancy vacancy) {
        vacancyService.addVacancy(vacancy);
        return HttpStatus.CREATED;
    }

}
