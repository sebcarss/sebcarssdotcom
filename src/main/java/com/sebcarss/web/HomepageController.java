package com.sebcarss.web;

import com.sebcarss.domain.Post;
import com.sebcarss.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomepageController {

    @Autowired
    private PostRepository postRepository;

    @RequestMapping("/")
    public String getHomepage(Model model) {
        List<Post> recentPosts = postRepository.findAllByOrderByDatePostedDesc();
        model.addAttribute("recentPosts", recentPosts);
        return "homepage";
    }
}
