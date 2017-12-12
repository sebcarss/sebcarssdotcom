package com.sebcarss.service;

import com.sebcarss.domain.Post;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    public Post findPostById(long id) {
        Post post = new Post();
        post.setUid(id);
        post.setTitle("Test Title");
        post.setHeadline("What a great article this is!");
        return post;
    }
}
