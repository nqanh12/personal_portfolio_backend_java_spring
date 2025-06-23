package com.quocanh.personal_portfolio_backend_java_spring.service;

import com.quocanh.personal_portfolio_backend_java_spring.model.Experience;

import java.util.List;
import java.util.Optional;

public interface ExperienceService {
    List<Experience> findAll();
    Optional<Experience> findById(String id);
    Experience save(Experience experience);
    void deleteById(String id);
} 