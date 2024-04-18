package com.diploma.projectDiploma.services;


import com.diploma.projectDiploma.entity.Worker;
import com.diploma.projectDiploma.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class WorkerService implements UserDetailsService {

    private final WorkerRepository workerRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public WorkerService(WorkerRepository workerRepository, PasswordEncoder passwordEncoder) {
        this.workerRepository = workerRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public Worker createWorker(Worker worker) {
        workerRepository.findByEmail(worker.getEmail())
                .ifPresent(w -> {
                    throw new ResponseStatusException(
                            HttpStatus.BAD_REQUEST,
                            "Worker with " + worker.getEmail() + " already registered"
                    );
                });
        worker.setPass(passwordEncoder.encode(worker.getPass()));
        return workerRepository.save(worker);
    }

    public List<Worker> findAllWorkers() {
        return workerRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Worker worker = workerRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Not found this email" + email));
        return  User.builder()
                .username(worker.getEmail())
                .password(worker.getPass()).build();
    }
}
