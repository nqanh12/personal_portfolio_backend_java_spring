package com.quocanh.personal_portfolio_backend_java_spring.repository;

import com.quocanh.personal_portfolio_backend_java_spring.model.BlogPost;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BlogPostRepository extends MongoRepository<BlogPost, String> {
    List<BlogPost> findByTagsContaining(String tag);
}
