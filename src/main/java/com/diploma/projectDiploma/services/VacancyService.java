package com.diploma.projectDiploma.services;


import com.diploma.projectDiploma.entity.Vacancy;
import com.diploma.projectDiploma.entity.Worker;
import com.diploma.projectDiploma.repository.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class VacancyService {

    private final VacancyRepository vacancyRepository;

    @Autowired
    public VacancyService(VacancyRepository vacancyRepository) {
        this.vacancyRepository = vacancyRepository;
    }

    public void addVacancy(Vacancy vacancy) {
        vacancyRepository.save(vacancy);
    }

    public void acceptVacancyFromWorker(Vacancy vacancy, Worker worker) {
        vacancy.setCandidateIds(Collections.singletonList(worker.getId()));
    }

}
