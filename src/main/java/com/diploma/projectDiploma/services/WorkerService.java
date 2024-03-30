package com.diploma.projectDiploma.services;


import com.diploma.projectDiploma.entity.Worker;
import com.diploma.projectDiploma.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class WorkerService {

    private final WorkerRepository workerRepository;

    public void validationPesel(String pesel) {

        if (pesel.length() != 11) {
            throw new IllegalArgumentException("Get true length PESEL ");
        }
    }

    @Autowired
    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }


    public Worker createWorker(Worker worker)
    {

        workerRepository.findByEmail(worker.getEmail())
                .ifPresent(w -> {
                    throw new ResponseStatusException(
                            HttpStatus.BAD_REQUEST,
                            "Worker with " + worker.getEmail() + " already registered"
                    );
                });
        return workerRepository.save(worker);
    }

    public List<Worker> findAllWorkers() {
        return workerRepository.findAll();
    }
}
