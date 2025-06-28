package com.quocanh.personal_portfolio_backend_java_spring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ExperienceDTO {
    private String id;

    @NotBlank(message = "Position is required")
    private String position;

    @NotBlank(message = "Company is required")
    private String company;

    @NotNull(message = "Start date is required")
    private LocalDate startDate;

    private LocalDate endDate;
    private List<String> description;
} 