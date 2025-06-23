package com.quocanh.personal_portfolio_backend_java_spring.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class ProjectDTO {
    private String id;

    @NotBlank(message = "Project name is required")
    private String name;

    @NotBlank(message = "Project description is required")
    private String description;

    private List<String> techStack;
    private String githubLink;
    private String demoLink;
    private String thumbnailImage;
} 