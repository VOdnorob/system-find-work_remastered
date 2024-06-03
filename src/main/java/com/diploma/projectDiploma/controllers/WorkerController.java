package com.diploma.projectDiploma.controllers;

import com.diploma.projectDiploma.entity.Vacancy;
import com.diploma.projectDiploma.entity.Worker;
import com.diploma.projectDiploma.services.EmailSender;
import com.diploma.projectDiploma.services.VacancyService;
import com.diploma.projectDiploma.services.WorkerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/api/workers")
public class WorkerController {

    private final WorkerService workerService;
    private final EmailSender emailSender;
    private final VacancyService vacancyService;

    @Autowired
    public WorkerController(WorkerService workerService, EmailSender emailSender, VacancyService vacancyService) {
        this.workerService = workerService;
        this.emailSender = emailSender;
        this.vacancyService = vacancyService;
    }

    @CrossOrigin
    @PostMapping("/createWorker")
    public HttpStatus createWorker(@Valid @RequestBody Worker worker) {
        workerService.createWorker(worker);
        emailSender.sendEmail(worker.getEmail(), "Registration", "Hello, you are successfully registered in our service");
        return HttpStatus.CREATED;
    }

    @CrossOrigin
    @PreAuthorize("hasRole('ROLE_WORKER')")
    @PutMapping("/acceptVacancy")
    public HttpStatus acceptVacancy(@RequestParam String vacancyID, Principal principal) {
        Worker worker = workerService.findByEmail(principal.getName());
        Vacancy vacancy= vacancyService.findVacancyById(vacancyID);
        vacancyService.acceptVacancyFromWorker(vacancy, worker);
        return HttpStatus.ACCEPTED;
    }


    @GetMapping("/findAllVacancy")
    public List<Vacancy> findVacancyByID() {
       return vacancyService.getAllVacancies();
    }

    @GetMapping("/findVacancyById")
    public Vacancy findVacancyById(@RequestParam String vacancyID) {
        return vacancyService.findVacancyById(vacancyID);
    }

    @PreAuthorize("hasRole('ROLE_EMPLOYER')")
    @GetMapping("/findWorker")
    public List<Worker> getAllWorkers() {
        return workerService.findAllWorkers();
    }
}



