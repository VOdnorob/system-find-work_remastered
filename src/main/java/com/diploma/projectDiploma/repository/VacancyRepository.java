package com.diploma.projectDiploma.repository;

import com.diploma.projectDiploma.entity.Vacancy;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VacancyRepository extends MongoRepository<Vacancy, String> {

    Optional<Vacancy> findById (String id);

    Optional<Vacancy> findByWorkerId (String title);

    Vacancy findByTitle (String name);

}
