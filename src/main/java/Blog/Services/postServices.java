package Blog.Services;
import java.util.ArrayList;
import java.util.Date;
import Blog.Model.post;
import org.springframework.stereotype.Service;
@Service
public class postServices
{
    public postServices()
    {
        System.out.println("*** post services***");
    }
    public ArrayList<post> getAllpost()
    {
        post p=new post();
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
        return listt;

    }
    public ArrayList<post>getOnePost()
    { post p=new post();
        ArrayList<post>listt=new ArrayList<>();
        p.setTitle("post 1");
        p.setBody("body of post1");
        p.setDate(new Date());
        listt.add(p);
        return listt;


    }
}
