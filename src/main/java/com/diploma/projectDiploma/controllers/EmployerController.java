package com.diploma.projectDiploma.controllers;


import com.diploma.projectDiploma.entity.Vacancy;
import com.diploma.projectDiploma.services.EmployerService;
import com.diploma.projectDiploma.services.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/employer")
public class EmployerController {


    private final VacancyService vacancyService;

    @Autowired
    public EmployerController(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @PreAuthorize("hasRole('ROLE_EMPLOYER')")
    @PostMapping("/createVacancy")
    public HttpStatus createVacancy(@RequestBody Vacancy vacancy) {
        vacancyService.addVacancy(vacancy);
        return HttpStatus.CREATED;
    }

}
