package Blog.Services;
import Blog.Model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    public boolean validUser(User u)
    {
        if (u.getUsername().equals("validuser") && (u.getPassword().equals("faiza")))

        return true;

else
    return false;


    }
}

