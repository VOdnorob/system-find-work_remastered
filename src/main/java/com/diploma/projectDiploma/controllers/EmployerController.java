package com.diploma.projectDiploma.controllers;


import com.diploma.projectDiploma.entity.Vacancy;
import com.diploma.projectDiploma.services.VacancyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
@PreAuthorize("hasRole('ROLE_EMPLOYER')")
@CrossOrigin
public class EmployerController {


    private final VacancyService vacancyService;

    @Autowired
    public EmployerController(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }



    @PostMapping("/vacancy")
    public HttpStatus createVacancy(@Valid @RequestBody Vacancy vacancy) {
        vacancyService.addVacancy(vacancy);
        return HttpStatus.CREATED;
    }

    @GetMapping("/vacancy")
    public List<Vacancy> getAllVacancies() {
        return vacancyService.getAllVacancies();
    }

    @PutMapping("/vacancy/{vacancyId}/worker/{workerId}")
    public HttpStatus updateVacancy(@PathVariable String vacancyId, @PathVariable String workerId) {
        vacancyService.acceptVacancyFromEmployer(vacancyId, workerId);
        return HttpStatus.OK;
    }

}
