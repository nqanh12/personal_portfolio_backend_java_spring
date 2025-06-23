package com.quocanh.personal_portfolio_backend_java_spring.service.impl;

import com.quocanh.personal_portfolio_backend_java_spring.model.Project;
import com.quocanh.personal_portfolio_backend_java_spring.repository.ProjectRepository;
import com.quocanh.personal_portfolio_backend_java_spring.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<Project> findById(String id) {
        return projectRepository.findById(id);
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void deleteById(String id) {
        projectRepository.deleteById(id);
    }
} 