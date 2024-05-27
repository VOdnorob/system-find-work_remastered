package com.diploma.projectDiploma.controllers;

import com.diploma.projectDiploma.entity.Worker;
import com.diploma.projectDiploma.services.EmailSender;
import com.diploma.projectDiploma.services.WorkerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/workers")
public class WorkerController {

    private final WorkerService workerService;
    private final EmailSender emailSender;

    @Autowired
    public WorkerController(WorkerService workerService, EmailSender emailSender) {
        this.workerService = workerService;
        this.emailSender = emailSender;
    }

    @CrossOrigin
    @PostMapping("/createWorker")
    public HttpStatus createWorker(@Valid @RequestBody Worker worker) {
        workerService.createWorker(worker);
        emailSender.sendEmail(worker.getEmail(), "Registration", "Hello, you are successfully registered in our service");
        return HttpStatus.CREATED;
    }

    @PreAuthorize("hasRole('ROLE_EMPLOYER')")
    @GetMapping("/findWorker")
    public List<Worker> getAllWorkers() {
        return workerService.findAllWorkers();
    }
}



