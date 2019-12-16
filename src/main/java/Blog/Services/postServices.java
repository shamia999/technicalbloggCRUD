package Blog.Services;
import java.sql.*;
import java.util.ArrayList;
import java.util.*;
import Blog.Model.post;
import org.springframework.stereotype.Service;
import Blog.Model.postModel;
import java.lang.*;
import org.springframework.ui.Model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import static java.lang.Class.forName;

@Service

public class postServices {
    @PersistenceUnit(unitName="post")
    private EntityManagerFactory emf;

    ArrayList<post> listt = new ArrayList<post>();

    /*public postServices()
    //{
    //  System.out.println("*** post services***");
    //} */

    public List<post> getAllpost()
    {

        EntityManager em =emf.createEntityManager();
        TypedQuery<post>tp =em.createQuery("SELECT op from post op",post.class);//expected type class
List<post>lp=tp.getResultList();
return lp;
     /*Connection connection=null;
        try {
          Class.forName("org.postgresql.Driver");

        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/post", "postgres", "9463690786");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM post");
        while (rs.next())
        {
            post p = new post();
            p.setTitle(rs.getString("title"));
            p.setBody(rs.getString("BODY"));
          listt.add(p);
        }

    }
     catch (ClassNotFoundException | SQLException ex)
    {
    ex.printStackTrace();
}
finally {
            try {
                connection.close();
            }
            catch (SQLException e)
            {e.printStackTrace();
            }
        }
       // return lp; */
    }


    public ArrayList<post> getOnePost() {

        ArrayList<post> lis = new ArrayList<>();
        /*p.setTitle("post 1");
        p.setBody("body of post1");
        p.setDate(new Date());
        listt.add(p);
        return listt; */
       Connection cc=null;
        try {
            Class.forName("org.postgresql.Driver");
            cc=DriverManager.getConnection("jdbc:postgresql://localhost:5433/post","postgres","9463690786");
        Statement ss=cc.createStatement();
          ResultSet r= ss.executeQuery("SELECT * FROM post where id= 1");
      while(r.next())
       {
           post pp=new post();
           pp.setTitle(r.getString("title"));
           pp.setBody(r.getString("BODY"));
           lis.add(pp);

       }

        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                cc.close();
            }
            catch(SQLException ee)
            {
                ee.printStackTrace();
            }
        }

return lis;
    }

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
