package Blog.Controller;
import Blog.Model.User;
import Blog.Model.User_Profile;
import Blog.Services.UserService;
import Blog.Services.postServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import Blog.Model.post;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    postServices postservices;
@Autowired
    UserService use;
    @RequestMapping("user/login")
    public String userLogin()
    {
        return "user/login";
    }
    @RequestMapping("user/registration")
    public String userRegistration(Model model)
    {
        User user=new User();
        User_Profile pro=new User_Profile();
        user.setProfile(pro);
        model.addAttribute("User",user);
        return "user/registration";
    }
    @RequestMapping(value="user/registration",method=RequestMethod.POST)
    public String getRegisteredData(User us)
    { use.regis(us);
        return "user/login";
    }
    @RequestMapping(value="user/login",method=RequestMethod.POST)
    public String loginUser(User user,HttpSession session)       //post method to jo data aaya usey check krne k liae pehle store kia User type ke object me
    {
        User rr=use.validUser(user);

        if(rr != null)
        { session.setAttribute("luser",rr);
            return "redirect:/posts";
              }

             else
            {
            return "user/login";
            }
    }
    /*@RequestMapping(value="user/logout" ,method=RequestMethod.POST)
    public String logout(Model model)
    {
        List<post> listt= postServices.getOnePost();
        model.addAttribute("postkey",listt);
        return "index";
    }

     */


}

