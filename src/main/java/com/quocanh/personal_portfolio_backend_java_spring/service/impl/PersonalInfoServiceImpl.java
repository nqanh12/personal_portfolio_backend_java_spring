package com.quocanh.personal_portfolio_backend_java_spring.service.impl;

import com.quocanh.personal_portfolio_backend_java_spring.model.PersonalInfo;
import com.quocanh.personal_portfolio_backend_java_spring.repository.PersonalInfoRepository;
import com.quocanh.personal_portfolio_backend_java_spring.service.PersonalInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonalInfoServiceImpl implements PersonalInfoService {
    private final PersonalInfoRepository personalInfoRepository;

    @Override
    public PersonalInfo save(PersonalInfo personalInfo) {
        return personalInfoRepository.save(personalInfo);
    }

    @Override
    public Optional<PersonalInfo> findById(String id) {
        return personalInfoRepository.findById(id);
    }

    @Override
    public Optional<PersonalInfo> findFirst() {
        return personalInfoRepository.findAll(PageRequest.of(0, 1))
                .stream()
                .findFirst();
    }

    @Override
    public void deleteById(String id) {
        personalInfoRepository.deleteById(id);
    }
}
