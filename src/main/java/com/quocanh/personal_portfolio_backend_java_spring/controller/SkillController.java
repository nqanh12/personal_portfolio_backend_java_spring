package com.quocanh.personal_portfolio_backend_java_spring.controller;

import com.quocanh.personal_portfolio_backend_java_spring.dto.SkillDTO;
import com.quocanh.personal_portfolio_backend_java_spring.model.Skill;
import com.quocanh.personal_portfolio_backend_java_spring.model.enums.SkillType;
import com.quocanh.personal_portfolio_backend_java_spring.service.SkillService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Skill API", description = "APIs for managing skill information")
@RestController
@RequestMapping("/api/skills")
@RequiredArgsConstructor
public class SkillController {
    private final SkillService skillService;

    @Operation(summary = "Lấy tất cả kỹ năng")
    @GetMapping
    public ResponseEntity<List<Skill>> getAllSkills() {
        return ResponseEntity.ok(skillService.findAll());
    }

    @Operation(summary = "Lấy kỹ năng theo loại")
    @GetMapping("/type/{type}")
    public ResponseEntity<List<Skill>> getSkillsByType(
        @Parameter(description = "Loại kỹ năng", required = true) @PathVariable SkillType type) {
        return ResponseEntity.ok(skillService.findByType(type));
    }

    @Operation(summary = "Lấy kỹ năng theo ID")
    @GetMapping("/{id}")
    public ResponseEntity<Skill> getSkillById(
        @Parameter(description = "ID của kỹ năng", required = true) @PathVariable String id) {
        return skillService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Tạo mới kỹ năng")
    @PostMapping
    public ResponseEntity<Skill> createSkill(@Valid @RequestBody SkillDTO skillDTO) {
        Skill skill = mapToEntity(skillDTO);
        return ResponseEntity.ok(skillService.save(skill));
    }

    @Operation(summary = "Cập nhật kỹ năng")
    @PutMapping("/{id}")
    public ResponseEntity<Skill> updateSkill(
            @Parameter(description = "ID của kỹ năng", required = true) @PathVariable String id,
            @Valid @RequestBody SkillDTO skillDTO) {
        return skillService.findById(id)
                .map(existing -> {
                    Skill updated = mapToEntity(skillDTO);
                    updated.setId(id);
                    return ResponseEntity.ok(skillService.save(updated));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Xóa kỹ năng")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSkill(
        @Parameter(description = "ID của kỹ năng", required = true) @PathVariable String id) {
        if (skillService.findById(id).isPresent()) {
            skillService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    private Skill mapToEntity(SkillDTO dto) {
        Skill skill = new Skill();
        skill.setId(dto.getId());
        skill.setName(dto.getName());
        skill.setIconUrl(dto.getIconUrl());
        skill.setType(dto.getType());
        skill.setLevel(dto.getLevel());
        return skill;
    }
}
