package com.quocanh.personal_portfolio_backend_java_spring.controller;

import com.quocanh.personal_portfolio_backend_java_spring.dto.EducationDTO;
import com.quocanh.personal_portfolio_backend_java_spring.model.Education;
import com.quocanh.personal_portfolio_backend_java_spring.service.EducationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/education")
@RequiredArgsConstructor
public class EducationController {
    private final EducationService educationService;

    @GetMapping
    public ResponseEntity<List<Education>> getAllEducation() {
        return ResponseEntity.ok(educationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Education> getEducationById(@PathVariable String id) {
        return educationService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Education> createEducation(@Valid @RequestBody EducationDTO educationDTO) {
        Education education = mapToEntity(educationDTO);
        return ResponseEntity.ok(educationService.save(education));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Education> updateEducation(
            @PathVariable String id,
            @Valid @RequestBody EducationDTO educationDTO) {
        return educationService.findById(id)
                .map(existing -> {
                    Education updated = mapToEntity(educationDTO);
                    updated.setId(id);
                    return ResponseEntity.ok(educationService.save(updated));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEducation(@PathVariable String id) {
        if (educationService.findById(id).isPresent()) {
            educationService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    private Education mapToEntity(EducationDTO dto) {
        Education education = new Education();
        education.setId(dto.getId());
        education.setSchool(dto.getSchool());
        education.setDegree(dto.getDegree());
        education.setStartDate(dto.getStartDate());
        education.setEndDate(dto.getEndDate());
        education.setDescription(dto.getDescription());
        return education;
    }
} 