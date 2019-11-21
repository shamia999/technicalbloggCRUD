package Blog.Controller;
import Blog.Model.User;
import Blog.Services.postServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import Blog.Model.post;

import java.util.ArrayList;

@Controller
public class UserController {
    @Autowired
    postServices postServices;

    @RequestMapping("user/login")
    public String userLogin()
    {
        return "user/login";
    }
    @RequestMapping("user/registration")
    public String userRegistration()
    {
        return "user/registration";
    }
    @RequestMapping(value="user/login",method=RequestMethod.POST)
    public String loginUser(User user)       //post method to jo data aaya usey check krne k liae pehle store kia User type ke object me
    {
        return "redirect:/posts";
    }
    @RequestMapping(value="user/logout" ,method=RequestMethod.POST)
    public String logout(Model model)
    {
        ArrayList<post> listt= postServices.getAllpost();
        model.addAttribute("postkey",listt);
        return "index";
    }
}

