package com.quocanh.personal_portfolio_backend_java_spring.repository;

import com.quocanh.personal_portfolio_backend_java_spring.model.Education;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EducationRepository extends MongoRepository<Education, String> {
}
