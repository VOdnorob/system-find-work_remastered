package com.diploma.projectDiploma.services;


import com.diploma.projectDiploma.entity.Employer;
import com.diploma.projectDiploma.entity.Worker;
import com.diploma.projectDiploma.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.stream.Collectors;


@Service
public class EmployerService implements UserDetailsService {

    private final EmployerRepository employerRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public EmployerService(EmployerRepository employerRepository, PasswordEncoder passwordEncoder) {
        this.employerRepository = employerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createEmployer(Employer employer) {
        employerRepository.findByEmail(employer.getEmail())
                .ifPresent(w -> {
                    throw new ResponseStatusException(
                            HttpStatus.BAD_REQUEST,
                            "Employer with " + employer.getEmail() + " already registered"
                    );
                });
        employer.setRoles(Collections.singleton("ROLE_EMPLOYER"));
        employer.setPassword(passwordEncoder.encode(employer.getPassword()));
        employerRepository.save(employer);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Employer worker = employerRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
        return new org.springframework.security.core.userdetails.User(worker.getEmail(), worker.getPassword(),
                worker.getRoles().stream()
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList()));
    }
}
