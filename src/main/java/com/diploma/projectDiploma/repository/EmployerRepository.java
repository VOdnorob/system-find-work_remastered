package com.diploma.projectDiploma.repository;

import com.diploma.projectDiploma.entity.Employer;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository {

    Employer findById(int id);

    Employer findByEmail(String email);
}
