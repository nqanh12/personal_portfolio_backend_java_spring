package com.quocanh.personal_portfolio_backend_java_spring.service.impl;

import com.quocanh.personal_portfolio_backend_java_spring.model.Education;
import com.quocanh.personal_portfolio_backend_java_spring.repository.EducationRepository;
import com.quocanh.personal_portfolio_backend_java_spring.service.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EducationServiceImpl implements EducationService {
    private final EducationRepository educationRepository;

    @Override
    public List<Education> findAll() {
        return educationRepository.findAll();
    }

    @Override
    public Optional<Education> findById(String id) {
        return educationRepository.findById(id);
    }

    @Override
    public Education save(Education education) {
        return educationRepository.save(education);
    }

    @Override
    public void deleteById(String id) {
        educationRepository.deleteById(id);
    }
} 