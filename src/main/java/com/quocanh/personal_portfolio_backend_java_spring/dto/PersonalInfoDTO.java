package com.quocanh.personal_portfolio_backend_java_spring.dto;

import lombok.Data;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.Map;

@Data
public class PersonalInfoDTO {
    private String id;

    @NotBlank(message = "Full name is required")
    private String fullName;

    @NotBlank(message = "Title is required")
    private String title;

    private String bio;

    @Email(message = "Invalid email format")
    private String email;

    private String phone;
    private String profileImageUrl;
    private Map<String, String> socialLinks;
}
