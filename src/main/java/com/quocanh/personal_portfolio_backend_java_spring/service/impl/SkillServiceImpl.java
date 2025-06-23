package com.quocanh.personal_portfolio_backend_java_spring.service.impl;

import com.quocanh.personal_portfolio_backend_java_spring.model.Skill;
import com.quocanh.personal_portfolio_backend_java_spring.model.enums.SkillType;
import com.quocanh.personal_portfolio_backend_java_spring.repository.SkillRepository;
import com.quocanh.personal_portfolio_backend_java_spring.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {
    private final SkillRepository skillRepository;

    @Override
    public List<Skill> findAll() {
        return skillRepository.findAll();
    }

    @Override
    public List<Skill> findByType(SkillType type) {
        return skillRepository.findByType(type);
    }

    @Override
    public Optional<Skill> findById(String id) {
        return skillRepository.findById(id);
    }

    @Override
    public Skill save(Skill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public void deleteById(String id) {
        skillRepository.deleteById(id);
    }
} 