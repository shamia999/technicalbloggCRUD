package Blog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import Blog.Services.postServices;
import  org.springframework.ui.Model;
import Blog.Model.post;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import Blog.Model.postModel;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    @Autowired
    private postServices postservices;
    @RequestMapping("posts")
    public String  getUserPosts(Model m)
    {
        List<post> posts= postservices.getAllpost();
        m.addAttribute("posts",posts);
        return "posts";
    }
    @RequestMapping("pos")
    public String getOnePost(Model mm)
    {
        ArrayList<post>ap=postservices.getOnePost();
        mm.addAttribute("pos",ap);
        return "pos";
    }
    /*@RequestMapping("/posts/create")
    public String Creatingpost()
    {
        return "posts/create";
    }
    @RequestMapping(value="/posts/create",method=RequestMethod.POST)

    public String getpostdata(postModel pm)
    {
        postservices.createpost(pm);
        return "redirect:/posts";
    }*/

}
