package Blog.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import Blog.Model.post;
import Blog.Services.postServices;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller


public class HomeController {
    public HomeController()
    {
        System.out.println("*** home controller **");
    }
    @Autowired
    private postServices op;
    @RequestMapping("/")

    public String getpostmethod(Model model)
    {
        List<post> listt= op.getAllpost();
        model.addAttribute("postkey",listt);
return "index";
    }
}
