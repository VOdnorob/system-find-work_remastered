package com.diploma.projectDiploma.controllers;


import com.diploma.projectDiploma.entity.Employer;
import com.diploma.projectDiploma.entity.Worker;
import com.diploma.projectDiploma.services.EmailSender;
import com.diploma.projectDiploma.services.EmployerService;
import com.diploma.projectDiploma.services.WorkerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@Controller("/user")
public class CreateUserController {

    private final EmployerService employerService;
    private final WorkerService workerService;
    private final EmailSender emailSender;

    @Autowired
    public CreateUserController(EmployerService employerService, WorkerService workerService, EmailSender emailSender) {
        this.employerService = employerService;
        this.workerService = workerService;
        this.emailSender = emailSender;
    }

    @PostMapping("/createWorker")
    public HttpStatus createWorker(@Valid @RequestBody Worker worker) {
        workerService.createWorker(worker);
        emailSender.sendEmail(worker.getEmail(), "Registration", "Hello, you are successfully registered in our service");
        return HttpStatus.CREATED;
    }

    @PostMapping("/createEmployer")
    public HttpStatus createEmployer(@Valid @RequestBody Employer employer) {
        employerService.createWorker(employer);
        emailSender.sendEmail(employer.getEmail(), "Registration", "Hello, you are successfully registered in our service");
        return HttpStatus.CREATED;
    }

}
