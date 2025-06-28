package com.quocanh.personal_portfolio_backend_java_spring.controller;

import com.quocanh.personal_portfolio_backend_java_spring.dto.ExperienceDTO;
import com.quocanh.personal_portfolio_backend_java_spring.model.Experience;
import com.quocanh.personal_portfolio_backend_java_spring.service.ExperienceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Experience API", description = "APIs for managing work experience information")
@RestController
@RequestMapping("/api/experiences")
@RequiredArgsConstructor
public class ExperienceController {
    private final ExperienceService experienceService;

    @Operation(summary = "Lấy tất cả kinh nghiệm làm việc")
    @GetMapping
    public ResponseEntity<List<Experience>> getAllExperiences() {
        return ResponseEntity.ok(experienceService.findAll());
    }

    @Operation(summary = "Lấy kinh nghiệm làm việc theo ID")
    @GetMapping("/{id}")
    public ResponseEntity<Experience> getExperienceById(
        @Parameter(description = "ID của kinh nghiệm", required = true) @PathVariable String id) {
        return experienceService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Tạo mới kinh nghiệm làm việc")
    @PostMapping
    public ResponseEntity<Experience> createExperience(@Valid @RequestBody ExperienceDTO experienceDTO) {
        Experience experience = mapToEntity(experienceDTO);
        return ResponseEntity.ok(experienceService.save(experience));
    }

    @Operation(summary = "Cập nhật kinh nghiệm làm việc")
    @PutMapping("/{id}")
    public ResponseEntity<Experience> updateExperience(
            @Parameter(description = "ID của kinh nghiệm", required = true) @PathVariable String id,
            @Valid @RequestBody ExperienceDTO experienceDTO) {
        return experienceService.findById(id)
                .map(existing -> {
                    Experience updated = mapToEntity(experienceDTO);
                    updated.setId(id);
                    return ResponseEntity.ok(experienceService.save(updated));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Xóa kinh nghiệm làm việc")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExperience(
        @Parameter(description = "ID của kinh nghiệm", required = true) @PathVariable String id) {
        if (experienceService.findById(id).isPresent()) {
            experienceService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    private Experience mapToEntity(ExperienceDTO dto) {
        Experience experience = new Experience();
        experience.setId(dto.getId());
        experience.setPosition(dto.getPosition());
        experience.setCompany(dto.getCompany());
        experience.setStartDate(dto.getStartDate());
        experience.setEndDate(dto.getEndDate());
        experience.setDescription(dto.getDescription());
        return experience;
    }
} 