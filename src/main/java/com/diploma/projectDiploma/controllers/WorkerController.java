package com.diploma.projectDiploma.controllers;

import com.diploma.projectDiploma.doMain.Worker;
import com.diploma.projectDiploma.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerController {

    private final WorkerService workerService;

    @Autowired
    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @PostMapping("/createWorker")
    public Worker createWorker( @RequestBody Worker worker) {

        return workerService.createWorker(worker);
    }

    @GetMapping("/findWorker")
    public List<Worker> getAllWorkers() {
        return workerService.findAllWorkers();
    }

}
