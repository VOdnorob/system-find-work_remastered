package com.diploma.projectDiploma.services;


import com.diploma.projectDiploma.doMain.Worker;
import com.diploma.projectDiploma.repository.WorkerRepository;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class WorkerService {

    ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    Validator validator = validatorFactory.getValidator();
    private final WorkerRepository workerRepository;
    private static final String EMAIL_REGEX = "^(.+)@(.+)$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public void validateEmail(String email){
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException("Bad format registered email");
        }
    }

    public void validationPesel(int pesel){
        String peselInString = Integer.toString(pesel);
        if (peselInString.length() != 1){
        throw new IllegalArgumentException("Get true length PESEL ");
        }
    }

    @Autowired
    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }


    public Worker createWorker(Worker worker)  {
        validateEmail(worker.getEmail());

        validationPesel(worker.getPESEL());

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
