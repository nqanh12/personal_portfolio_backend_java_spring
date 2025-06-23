package com.quocanh.personal_portfolio_backend_java_spring.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "projects")
public class Project {
    @Id
    private String id;
    private String name;
    private String description;
    private List<String> techStack;
    private String githubLink;
    private String demoLink;
    private String thumbnailImage;
}
