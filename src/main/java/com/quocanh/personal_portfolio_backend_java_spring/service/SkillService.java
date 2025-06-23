package com.quocanh.personal_portfolio_backend_java_spring.service;

import com.quocanh.personal_portfolio_backend_java_spring.model.Skill;
import com.quocanh.personal_portfolio_backend_java_spring.model.enums.SkillType;

import java.util.List;
import java.util.Optional;

public interface SkillService {
    List<Skill> findAll();
    List<Skill> findByType(SkillType type);
    Optional<Skill> findById(String id);
    Skill save(Skill skill);
    void deleteById(String id);
} 