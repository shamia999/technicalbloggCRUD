package Blog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import Blog.Services.postServices;
import  org.springframework.ui.Model;
import Blog.Model.post;
import java.util.ArrayList;

@Controller
public class PostController {
    @Autowired
    private postServices postservices;
    @RequestMapping("posts")
    public String  getUserPosts(Model m)
    {
        ArrayList<post>posts= postservices.getOnePost();
        m.addAttribute("posts",posts);
        return "posts";
    }
}
