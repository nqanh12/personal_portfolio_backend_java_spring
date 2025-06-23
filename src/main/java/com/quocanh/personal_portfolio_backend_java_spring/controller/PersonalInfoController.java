package com.quocanh.personal_portfolio_backend_java_spring.controller;

import com.quocanh.personal_portfolio_backend_java_spring.dto.PersonalInfoDTO;
import com.quocanh.personal_portfolio_backend_java_spring.model.PersonalInfo;
import com.quocanh.personal_portfolio_backend_java_spring.service.PersonalInfoService;  
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/personal-info")
@RequiredArgsConstructor
public class PersonalInfoController {
    private final PersonalInfoService personalInfoService;

    @GetMapping
    public ResponseEntity<PersonalInfo> getPersonalInfo() {
        return personalInfoService.findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PersonalInfo> createPersonalInfo(@Valid @RequestBody PersonalInfoDTO personalInfoDTO) {
        PersonalInfo personalInfo = mapToEntity(personalInfoDTO);
        return ResponseEntity.ok(personalInfoService.save(personalInfo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonalInfo> updatePersonalInfo(
            @PathVariable String id,
            @Valid @RequestBody PersonalInfoDTO personalInfoDTO) {
        return personalInfoService.findById(id)
                .map(existing -> {
                    PersonalInfo updated = mapToEntity(personalInfoDTO);
                    updated.setId(id);
                    return ResponseEntity.ok(personalInfoService.save(updated));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonalInfo(@PathVariable String id) {
        if (personalInfoService.findById(id).isPresent()) {
            personalInfoService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    private PersonalInfo mapToEntity(PersonalInfoDTO dto) {
        PersonalInfo entity = new PersonalInfo();
        entity.setId(dto.getId());
        entity.setFullName(dto.getFullName());
        entity.setTitle(dto.getTitle());
        entity.setBio(dto.getBio());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setProfileImageUrl(dto.getProfileImageUrl());
        entity.setSocialLinks(dto.getSocialLinks());
        return entity;
    }
}
