package com.quocanh.personal_portfolio_backend_java_spring.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BlogPostDTO {
    private String id;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Content is required")
    private String content;

    private LocalDateTime createdAt;
    private List<String> tags;
} 