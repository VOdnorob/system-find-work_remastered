package com.diploma.projectDiploma.repository;

import com.diploma.projectDiploma.entity.Employer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployerRepository extends MongoRepository<Employer, String> {

    Optional<Employer> findById(String id);

    Optional <Employer> findByEmail(String email);
}
