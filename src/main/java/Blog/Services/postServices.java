package Blog.Services;
import java.sql.*;
import java.util.ArrayList;
import java.util.*;
import Blog.Model.post;
import Blog.Repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Blog.Model.postModel;
import java.lang.*;
import java.util.Date;

import org.springframework.ui.Model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import static java.lang.Class.forName;

@Service

public class postServices {

@Autowired
    private PostRepo postrepository;

    public List <post> getAllpost()
    {
        return postrepository.getAllpost();
    }
public post getOnePost()
{
    return postrepository.getLatestPost();
}
public void createpost(post newpost)
{
    newpost.setDate(new Date());
    postrepository.createpost(newpost);
    System.out.println("newpost"+newpost);
}
public post get(Integer postId)
{
    post pp=postrepository.get(postId);
    return pp;
}
public void setpost(post pst)
{
    pst.setDate(new Date());
    postrepository.update(pst);
}
public void delete(String posttitle)
{
    postrepository.delete(posttitle);
}





   /*public ArrayList<post> getOnePost() {

        ArrayList<post> lis = new ArrayList<>();
        /*p.setTitle("post 1");
        p.setBody("body of post1");
        p.setDate(new Date());
        listt.add(p);
        return listt; */









    /* public void createpost(postModel pn) {
        post pp = new post();
    /*postModel pp=new postModel();
    String title=null;
pp.setTitleOfPost(title);
String details=null;
pp.setPostDetails(details);
ArrayList<postModel>pm=new ArrayList<>();
pm.add(pp);
mo.addAttribute("pm",pm);
return "/posts/create"; */
//listt.add(pp.setTitle(pn.getTitleOfPost()));

//}
//}

    }

