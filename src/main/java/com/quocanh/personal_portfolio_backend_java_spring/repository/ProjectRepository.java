package com.quocanh.personal_portfolio_backend_java_spring.repository;

import com.quocanh.personal_portfolio_backend_java_spring.model.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectRepository extends MongoRepository<Project, String> {
}
