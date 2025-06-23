package com.quocanh.personal_portfolio_backend_java_spring.service.impl;

import com.quocanh.personal_portfolio_backend_java_spring.model.Experience;
import com.quocanh.personal_portfolio_backend_java_spring.repository.ExperienceRepository;
import com.quocanh.personal_portfolio_backend_java_spring.service.ExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExperienceServiceImpl implements ExperienceService {
    private final ExperienceRepository experienceRepository;

    @Override
    public List<Experience> findAll() {
        return experienceRepository.findAll();
    }

    @Override
    public Optional<Experience> findById(String id) {
        return experienceRepository.findById(id);
    }

    @Override
    public Experience save(Experience experience) {
        return experienceRepository.save(experience);
    }

    @Override
    public void deleteById(String id) {
        experienceRepository.deleteById(id);
    }
} 