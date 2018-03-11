package com.sebcarss.web;

import com.sebcarss.domain.Post;
import com.sebcarss.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class PostsController {

    public static final String POST = "post";
    public static final String REDIRECT_HOME = "redirect:/";

    @Autowired
    private PostRepository postRepository;

    @RequestMapping("/{permalink}")
    public String getPostByPermalink(@PathVariable("permalink") String permalink, Model model) {
        Post post = (Post) postRepository.findByPermalink(permalink);

        if (post != null) {
            model.addAttribute("post", post);
            return POST;
        } else {
            return REDIRECT_HOME;
        }
    }
}
