package com.quocanh.personal_portfolio_backend_java_spring.service.impl;

import com.quocanh.personal_portfolio_backend_java_spring.model.BlogPost;
import com.quocanh.personal_portfolio_backend_java_spring.repository.BlogPostRepository;
import com.quocanh.personal_portfolio_backend_java_spring.service.BlogPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlogPostServiceImpl implements BlogPostService {
    private final BlogPostRepository blogPostRepository;

    @Override
    public List<BlogPost> findAll() {
        return blogPostRepository.findAll();
    }

    @Override
    public Optional<BlogPost> findById(String id) {
        return blogPostRepository.findById(id);
    }

    @Override
    public List<BlogPost> findByTag(String tag) {
        return blogPostRepository.findByTagsContaining(tag);
    }

    @Override
    public BlogPost save(BlogPost blogPost) {
        if (blogPost.getCreatedAt() == null) {
            blogPost.setCreatedAt(java.time.LocalDateTime.now());
        }
        return blogPostRepository.save(blogPost);
    }

    @Override
    public void deleteById(String id) {
        blogPostRepository.deleteById(id);
    }
} 