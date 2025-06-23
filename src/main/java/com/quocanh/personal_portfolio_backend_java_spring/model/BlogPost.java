package com.quocanh.personal_portfolio_backend_java_spring.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "blog_posts")
public class BlogPost {
    @Id
    private String id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private List<String> tags;
}
