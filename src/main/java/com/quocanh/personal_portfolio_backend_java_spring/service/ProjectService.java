package com.quocanh.personal_portfolio_backend_java_spring.service;

import com.quocanh.personal_portfolio_backend_java_spring.model.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<Project> findAll();
    Optional<Project> findById(String id);
    Project save(Project project);
    void deleteById(String id);
} 