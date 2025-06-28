package com.quocanh.personal_portfolio_backend_java_spring.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Map;

@Data
@Document(collection = "personal_info")
public class PersonalInfo {
    @Id
    private String id;
    private String fullName;
    private String title;
    private String bio;
    private String location;
    private String cvUrl;
    private String email;
    private String phone;
    private String profileImageUrl;
    private Map<String, String> socialLinks; // Key: platform name (e.g., "LinkedIn"), Value: URL

    // Getters and Setters
}
