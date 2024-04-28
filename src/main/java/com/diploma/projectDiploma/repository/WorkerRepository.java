package com.diploma.projectDiploma.repository;

import com.diploma.projectDiploma.entity.Worker;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkerRepository extends MongoRepository<Worker, String> {

    Optional<Worker> findByEmail(String email);

    Optional<Worker> findByPesel(String pesel);

    List<Worker> findByName(String name);

    List<Worker> findByCity (String city);

    Optional<Worker> findById (String id);

}
