package com.quocanh.personal_portfolio_backend_java_spring.service;

import com.quocanh.personal_portfolio_backend_java_spring.model.BlogPost;

import java.util.List;
import java.util.Optional;

public interface BlogPostService {
    List<BlogPost> findAll();
    Optional<BlogPost> findById(String id);
    List<BlogPost> findByTag(String tag);
    BlogPost save(BlogPost blogPost);
    void deleteById(String id);
} 