package Blog.Services;
import Blog.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Blog.Repository.userRepo;
@Service
public class UserService
{@Autowired
    private userRepo userrepo;
    public User validUser(User u)
    {
        User ui= userrepo.checkuser(u.getUsername(),u.getPassword());
        if(ui !=null)
        {
            return ui;
        }
else
        {
            return null;
        }
    }
    public void regis(User uu)
    {
        userrepo.regis(uu);
    }
}

