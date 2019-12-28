package Blog.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import Blog.Services.postServices;
import org.springframework.ui.Model;
import Blog.Model.post;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import Blog.Model.postModel;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    @Autowired
    private postServices postservices;

    @RequestMapping("posts")
    public String getUserPosts(Model m) {
        List<post> posts = postservices.getAllpost();
        m.addAttribute("posts", posts);
        return "posts";
    }

    @RequestMapping("pos")
    public String getOnePostt(Model mm) {
        ArrayList<post> ap = new ArrayList<>();
        post pm = postservices.getOnePost();
        ap.add(pm);
        mm.addAttribute("pos", ap);
        return "pos";
    }

    @RequestMapping("/posts/create")
    public String Creatingpost() {
        return "posts/create";
    }

    @RequestMapping(value = "/posts/create", method = RequestMethod.POST)
    public String createpost(post pm) {
        postservices.createpost(pm);
        return "redirect:/posts";
    }

    @RequestMapping(value = "/editpost", method = RequestMethod.GET)
    public String getpost(@RequestParam(name="post") Integer postId, Model model)
    {
        post ppp = postservices.get(postId);
model.addAttribute("post",ppp);
return "/posts/edit";
    }
    @RequestMapping(value="/editpost",method=RequestMethod.POST)
    public String setpost(@RequestParam(name="post")Integer post,post po)
    {
        po.setId(post);
        postservices.setpost(po);
        return "redirect:/posts";        //requestMappring posts naal wire up hoju
    }
    @RequestMapping(value="/deletepost" ,method=RequestMethod.POST)
    public String delete(@RequestParam(name="posttitle")String posttitle)
    {
        postservices.delete(posttitle);
      return  "redirect:/posts";
    }
}