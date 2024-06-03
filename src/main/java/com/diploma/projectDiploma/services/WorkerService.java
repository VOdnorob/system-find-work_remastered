package com.diploma.projectDiploma.services;


import com.diploma.projectDiploma.entity.Worker;
import com.diploma.projectDiploma.repository.VacancyRepository;
import com.diploma.projectDiploma.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkerService implements UserDetailsService {

    private final WorkerRepository workerRepository;
    private final PasswordEncoder passwordEncoder;
    private final VacancyRepository vacancyRepository;

    @Autowired
    public WorkerService(WorkerRepository workerRepository, PasswordEncoder passwordEncoder, VacancyRepository vacancyRepository) {
        this.workerRepository = workerRepository;
        this.passwordEncoder = passwordEncoder;
        this.vacancyRepository = vacancyRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Worker worker = workerRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
        return new org.springframework.security.core.userdetails.User(worker.getEmail(), worker.getPassword(),
                worker.getRoles().stream()
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList()));
    }


    public void createWorker(Worker worker) {
        workerRepository.findByEmail(worker.getEmail())
                .ifPresent(w -> {
                    throw new ResponseStatusException(
                            HttpStatus.BAD_REQUEST,
                            "Worker with " + worker.getEmail() + " already registered"
                    );
                });
        workerRepository.findByPesel(worker.getPesel())
                .ifPresent(w -> {
                    throw new ResponseStatusException(
                            HttpStatus.BAD_REQUEST,
                            "Worker with " + worker.getPesel() + " already registered"
                    );
                });
        worker.setPassword(passwordEncoder.encode(worker.getPassword()));
        workerRepository.save(worker);
    }

    public List<Worker> findAllWorkers() {
        return workerRepository.findAll();
    }

    public Worker findWorkerById(String workerId) {
        return workerRepository.findById(workerId).orElse(null);
    }

    public Worker findByEmail(String email) {
        return workerRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
    }


}
