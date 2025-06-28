package com.quocanh.personal_portfolio_backend_java_spring.controller;

import com.quocanh.personal_portfolio_backend_java_spring.dto.ProjectDTO;
import com.quocanh.personal_portfolio_backend_java_spring.model.Project;
import com.quocanh.personal_portfolio_backend_java_spring.service.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Project API", description = "APIs for managing project information")
@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @Operation(summary = "Lấy tất cả dự án")
    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        return ResponseEntity.ok(projectService.findAll());
    }

    @Operation(summary = "Lấy dự án theo ID")
    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(
        @Parameter(description = "ID của dự án", required = true) @PathVariable String id) {
        return projectService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Tạo mới dự án")
    @PostMapping
    public ResponseEntity<Project> createProject(@Valid @RequestBody ProjectDTO projectDTO) {
        Project project = mapToEntity(projectDTO);
        return ResponseEntity.ok(projectService.save(project));
    }

    @Operation(summary = "Cập nhật dự án")
    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(
            @Parameter(description = "ID của dự án", required = true) @PathVariable String id,
            @Valid @RequestBody ProjectDTO projectDTO) {
        return projectService.findById(id)
                .map(existing -> {
                    Project updated = mapToEntity(projectDTO);
                    updated.setId(id);
                    return ResponseEntity.ok(projectService.save(updated));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Xóa dự án")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(
        @Parameter(description = "ID của dự án", required = true) @PathVariable String id) {
        if (projectService.findById(id).isPresent()) {
            projectService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    private Project mapToEntity(ProjectDTO dto) {
        Project project = new Project();
        project.setId(dto.getId());
        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setTechStack(dto.getTechStack());
        project.setGithubLink(dto.getGithubLink());
        project.setDemoLink(dto.getDemoLink());
        project.setImages(dto.getImages());
        return project;
    }
} 