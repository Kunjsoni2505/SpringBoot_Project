package org.first.first.Controller;
import java.util.List;

import org.first.first.models.Post;
import org.first.first.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;;

@Controller
public class HomeController {
    @Autowired
    private PostService postService;
    @GetMapping("/")
    public String home(Model model){
        List<Post> posts = postService.getAll();
        model.addAttribute("posts", posts);
        return "home";
    }
}
