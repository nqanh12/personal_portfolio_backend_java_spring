package com.quocanh.personal_portfolio_backend_java_spring.repository;

import com.quocanh.personal_portfolio_backend_java_spring.model.Skill;
import com.quocanh.personal_portfolio_backend_java_spring.model.enums.SkillType;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SkillRepository extends MongoRepository<Skill, String> {
    List<Skill> findByType(SkillType type);
}
