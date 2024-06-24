package com.diploma.projectDiploma.services;


import com.diploma.projectDiploma.entity.Employer;
import com.diploma.projectDiploma.entity.Worker;
import com.diploma.projectDiploma.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@Service
public class EmployerService {

    private final EmployerRepository employerRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public EmployerService(EmployerRepository employerRepository, PasswordEncoder passwordEncoder) {
        this.employerRepository = employerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createWorker(Employer employer) {
        employerRepository.findByEmail(employer.getEmail())
                .ifPresent(w -> {
                    throw new ResponseStatusException(
                            HttpStatus.BAD_REQUEST,
                            "Worker with " + employer.getEmail() + " already registered"
                    );
                });
        employer.setPassword(passwordEncoder.encode(employer.getPassword()));
        employerRepository.save(employer);
    }

}
