package com.quocanh.personal_portfolio_backend_java_spring.service;

import com.quocanh.personal_portfolio_backend_java_spring.model.Education;

import java.util.List;
import java.util.Optional;

public interface EducationService {
    List<Education> findAll();
    Optional<Education> findById(String id);
    Education save(Education education);
    void deleteById(String id);
} 