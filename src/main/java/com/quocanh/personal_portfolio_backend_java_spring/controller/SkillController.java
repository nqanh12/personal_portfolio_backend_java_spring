package com.quocanh.personal_portfolio_backend_java_spring.controller;

import com.quocanh.personal_portfolio_backend_java_spring.dto.SkillDTO;
import com.quocanh.personal_portfolio_backend_java_spring.model.Skill;
import com.quocanh.personal_portfolio_backend_java_spring.model.enums.SkillType;
import com.quocanh.personal_portfolio_backend_java_spring.service.SkillService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@RequiredArgsConstructor
public class SkillController {
    private final SkillService skillService;

    @GetMapping
    public ResponseEntity<List<Skill>> getAllSkills() {
        return ResponseEntity.ok(skillService.findAll());
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<Skill>> getSkillsByType(@PathVariable SkillType type) {
        return ResponseEntity.ok(skillService.findByType(type));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Skill> getSkillById(@PathVariable String id) {
        return skillService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Skill> createSkill(@Valid @RequestBody SkillDTO skillDTO) {
        Skill skill = mapToEntity(skillDTO);
        return ResponseEntity.ok(skillService.save(skill));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Skill> updateSkill(
            @PathVariable String id,
            @Valid @RequestBody SkillDTO skillDTO) {
        return skillService.findById(id)
                .map(existing -> {
                    Skill updated = mapToEntity(skillDTO);
                    updated.setId(id);
                    return ResponseEntity.ok(skillService.save(updated));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSkill(@PathVariable String id) {
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
        skill.setType(dto.getType());
        skill.setLevel(dto.getLevel());
        return skill;
    }
} 