package com.sebcarss.repository;

import com.sebcarss.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, Long> {
    public Post findById(long id);
    public Post findByYearAndMonthAndDayAndPermalink(int year, int month, int day, String permalink);
}
