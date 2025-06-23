package com.quocanh.personal_portfolio_backend_java_spring.controller;

import com.quocanh.personal_portfolio_backend_java_spring.dto.BlogPostDTO;
import com.quocanh.personal_portfolio_backend_java_spring.model.BlogPost;
import com.quocanh.personal_portfolio_backend_java_spring.service.BlogPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog-posts")
@RequiredArgsConstructor
public class BlogPostController {
    private final BlogPostService blogPostService;

    @GetMapping
    public ResponseEntity<List<BlogPost>> getAllBlogPosts() {
        return ResponseEntity.ok(blogPostService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogPost> getBlogPostById(@PathVariable String id) {
        return blogPostService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/tag/{tag}")
    public ResponseEntity<List<BlogPost>> getBlogPostsByTag(@PathVariable String tag) {
        return ResponseEntity.ok(blogPostService.findByTag(tag));
    }

    @PostMapping
    public ResponseEntity<BlogPost> createBlogPost(@Valid @RequestBody BlogPostDTO blogPostDTO) {
        BlogPost blogPost = mapToEntity(blogPostDTO);
        return ResponseEntity.ok(blogPostService.save(blogPost));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlogPost> updateBlogPost(
            @PathVariable String id,
            @Valid @RequestBody BlogPostDTO blogPostDTO) {
        return blogPostService.findById(id)
                .map(existing -> {
                    BlogPost updated = mapToEntity(blogPostDTO);
                    updated.setId(id);
                    return ResponseEntity.ok(blogPostService.save(updated));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlogPost(@PathVariable String id) {
        if (blogPostService.findById(id).isPresent()) {
            blogPostService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    private BlogPost mapToEntity(BlogPostDTO dto) {
        BlogPost blogPost = new BlogPost();
        blogPost.setId(dto.getId());
        blogPost.setTitle(dto.getTitle());
        blogPost.setContent(dto.getContent());
        blogPost.setCreatedAt(dto.getCreatedAt());
        blogPost.setTags(dto.getTags());
        return blogPost;
    }
} 