package com.quocanh.personal_portfolio_backend_java_spring.dto;

import com.quocanh.personal_portfolio_backend_java_spring.model.enums.SkillLevel;
import com.quocanh.personal_portfolio_backend_java_spring.model.enums.SkillType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SkillDTO {
    private String id;

    @NotBlank(message = "Skill name is required")
    private String name;

    @NotBlank(message = "Skill icon is required")
    private String iconUrl;

    @NotNull(message = "Skill type is required")
    private SkillType type;

    @NotNull(message = "Skill level is required")
    private SkillLevel level;
}
