package com.quocanh.personal_portfolio_backend_java_spring.repository;

import com.quocanh.personal_portfolio_backend_java_spring.model.PersonalInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonalInfoRepository extends MongoRepository<PersonalInfo, String> {
}

