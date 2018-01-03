package com.sebcarss.repository;

import com.sebcarss.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, Long> {
    public Post findById(long id);
    public Post findByPermalink(String permalink);
    public List<Post> findAllByCategory(String category);
}
