package Blog.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import Blog.Model.post;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class HomeController {
    @RequestMapping("/")

    public String getpostmethod(Model model)
    { post p=new post();
    ArrayList<post>listt=new ArrayList<post>();
        p.setTitle("post 1");
        p.setBody("body of post1");
        p.setDate(new Date());

        post p2=new post();
        p2.setTitle("post 2");
        p2.setBody("body of post2");
        p2.setDate(new Date());
        listt.add(p);
        listt.add(p2);
        model.addAttribute("postkey",listt);
return "index";
    }
}
