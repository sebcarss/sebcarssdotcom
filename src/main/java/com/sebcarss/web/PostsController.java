package com.sebcarss.web;

import com.sebcarss.domain.Post;
import com.sebcarss.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostsController {

    @Autowired
    private PostService postService;

    @RequestMapping("/post/{id}")
    public String getPostById(@PathVariable("id") long id, Model model) {
        Post post = postService.findPostById(id);
        model.addAttribute("post", post);
        return "post";
    }
}
