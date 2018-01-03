package com.sebcarss.web;

import com.sebcarss.domain.Post;
import com.sebcarss.domain.RecipePost;
import com.sebcarss.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PostsController {

    @Autowired
    private PostRepository postRepository;

    @RequestMapping("/post/{id}")
    public String getPostById(@PathVariable("id") long id, Model model) {
        Post post = postRepository.findById(id);
        model.addAttribute("post", post);
        return "post";
    }

    @RequestMapping("/ramen/{permalink}")
    public String getRamenPostById(@PathVariable("permalink") String permalink, Model model) {
        RecipePost ramenPost = (RecipePost) postRepository.findByPermalink(permalink);
        model.addAttribute("post", ramenPost);
        return "ramen-post";
    }
}
