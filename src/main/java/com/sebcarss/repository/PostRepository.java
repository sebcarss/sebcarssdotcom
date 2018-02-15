package com.sebcarss.repository;

import com.sebcarss.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, Long> {
    public Post findById(long id);
    public Post findByPermalink(String permalink);

    // Find all posts for a specific category, e.g. all posts about ramen
    public List<Post> findTop5ByCategoryOrderByDatePostedDesc(String category);

    // Find all posts for the homepage
    public List<Post> findTop5ByOrderByDatePostedDesc();

    // Find all posts ordered by date posted
    public List<Post> findAllByOrderByDatePostedDesc();
}
