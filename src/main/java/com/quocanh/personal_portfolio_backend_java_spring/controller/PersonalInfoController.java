package com.quocanh.personal_portfolio_backend_java_spring.controller;

import com.quocanh.personal_portfolio_backend_java_spring.dto.PersonalInfoDTO;
import com.quocanh.personal_portfolio_backend_java_spring.model.PersonalInfo;
import com.quocanh.personal_portfolio_backend_java_spring.service.PersonalInfoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Personal Info API", description = "APIs for managing personal information")
@RestController
@RequestMapping("/api/personal-info")
@RequiredArgsConstructor
public class PersonalInfoController {
    private final PersonalInfoService personalInfoService;

    @Operation(summary = "Lấy thông tin cá nhân đầu tiên")
    @GetMapping
    public ResponseEntity<PersonalInfo> getPersonalInfo() {
        return personalInfoService.findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Tạo mới thông tin cá nhân")
    @PostMapping
    public ResponseEntity<PersonalInfo> createPersonalInfo(@Valid @RequestBody PersonalInfoDTO personalInfoDTO) {
        PersonalInfo personalInfo = mapToEntity(personalInfoDTO);
        return ResponseEntity.ok(personalInfoService.save(personalInfo));
    }

    @Operation(summary = "Cập nhật thông tin cá nhân")
    @PutMapping("/{id}")
    public ResponseEntity<PersonalInfo> updatePersonalInfo(
            @Parameter(description = "ID của thông tin cá nhân", required = true) @PathVariable String id,
            @Valid @RequestBody PersonalInfoDTO personalInfoDTO) {
        return personalInfoService.findById(id)
                .map(existing -> {
                    PersonalInfo updated = mapToEntity(personalInfoDTO);
                    updated.setId(id);
                    return ResponseEntity.ok(personalInfoService.save(updated));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Xóa thông tin cá nhân")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonalInfo(
        @Parameter(description = "ID của thông tin cá nhân", required = true) @PathVariable String id) {
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
        entity.setLocation(dto.getLocation());
        entity.setCvUrl(dto.getCvUrl());
        entity.setBio(dto.getBio());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setProfileImageUrl(dto.getProfileImageUrl());
        entity.setSocialLinks(dto.getSocialLinks());
        return entity;
    }
}
