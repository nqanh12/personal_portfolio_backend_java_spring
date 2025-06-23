package com.quocanh.personal_portfolio_backend_java_spring.controller;

import com.quocanh.personal_portfolio_backend_java_spring.dto.ExperienceDTO;
import com.quocanh.personal_portfolio_backend_java_spring.model.Experience;
import com.quocanh.personal_portfolio_backend_java_spring.service.ExperienceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experiences")
@RequiredArgsConstructor
public class ExperienceController {
    private final ExperienceService experienceService;

    @GetMapping
    public ResponseEntity<List<Experience>> getAllExperiences() {
        return ResponseEntity.ok(experienceService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Experience> getExperienceById(@PathVariable String id) {
        return experienceService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Experience> createExperience(@Valid @RequestBody ExperienceDTO experienceDTO) {
        Experience experience = mapToEntity(experienceDTO);
        return ResponseEntity.ok(experienceService.save(experience));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Experience> updateExperience(
            @PathVariable String id,
            @Valid @RequestBody ExperienceDTO experienceDTO) {
        return experienceService.findById(id)
                .map(existing -> {
                    Experience updated = mapToEntity(experienceDTO);
                    updated.setId(id);
                    return ResponseEntity.ok(experienceService.save(updated));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExperience(@PathVariable String id) {
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