package com.quocanh.personal_portfolio_backend_java_spring.service;

import com.quocanh.personal_portfolio_backend_java_spring.model.PersonalInfo;

import java.util.Optional;

public interface PersonalInfoService {
    PersonalInfo save(PersonalInfo personalInfo);
    Optional<PersonalInfo> findById(String id);
    Optional<PersonalInfo> findFirst();
    void deleteById(String id);
}
