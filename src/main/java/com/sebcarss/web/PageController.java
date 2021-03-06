package com.sebcarss.web;

import com.sebcarss.domain.Post;
import com.sebcarss.domain.RecipePost;
import com.sebcarss.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PageController {

    @Autowired
    private PostRepository postRepository;

    @RequestMapping("/ramen")
    public String getCategoryPage(Model model) {
        List<Post> posts = (List<Post>) postRepository.findTop5ByCategoryOrderByDatePostedDesc("ramen");

        List<RecipePost> recipePosts = new ArrayList<>();
        for (Post post : posts) {
            if (post instanceof RecipePost) {
                recipePosts.add((RecipePost) post);
            }
        }

        model.addAttribute("posts", recipePosts);
        return "landing-zone-recipes";
    }
}
