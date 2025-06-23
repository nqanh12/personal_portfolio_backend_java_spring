package com.quocanh.personal_portfolio_backend_java_spring.repository;

import com.quocanh.personal_portfolio_backend_java_spring.model.Experience;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExperienceRepository extends MongoRepository<Experience, String> {
}
