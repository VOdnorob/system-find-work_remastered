package com.diploma.projectDiploma.services;


import com.diploma.projectDiploma.entity.Vacancy;
import com.diploma.projectDiploma.entity.Worker;
import com.diploma.projectDiploma.repository.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
public class VacancyService {

    private final VacancyRepository vacancyRepository;
    private final WorkerService workerService;

    @Autowired
    public VacancyService(VacancyRepository vacancyRepository, WorkerService workerService) {
        this.vacancyRepository = vacancyRepository;
        this.workerService = workerService;
    }

    public void addVacancy(Vacancy vacancy) {
        vacancyRepository.save(vacancy);
    }

    public List<Vacancy> getAllVacancies() {
      return vacancyRepository.findAll();
    }

    public Vacancy findVacancyById(String id) {
        return vacancyRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Vacancy not found"));
    }

    public void acceptVacancyFromEmployer(String vacancyId, String workerId) {
        workerService.checkIfWorkerExists(workerId);
        Vacancy vacancy = findVacancyById(vacancyId);
        vacancy.setAccepted(true);
        vacancy.setWorkerId(workerId);
        vacancy.getCandidateIds().clear();
        vacancyRepository.save(vacancy);
    }

    public void acceptVacancyFromWorker(Vacancy vacancy, Worker worker) {
        Set<String> candidateIds = vacancy.getCandidateIds();
        if (candidateIds == null) {
            candidateIds = new HashSet<>();
        }
        candidateIds.add(worker.getId());
        vacancy.setCandidateIds(candidateIds);
        vacancyRepository.save(vacancy);
    }


}
