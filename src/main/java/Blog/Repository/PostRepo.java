package Blog.Repository;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;
import Blog.Model.post;
@Repository
public class PostRepo //define the database layer of project
{
    @PersistenceUnit(unitName = "post")
    private EntityManagerFactory emf;

    public List<post> getAllpost() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<post> tp = em.createQuery("SELECT p from post p", post.class);

        List<post> lp = tp.getResultList();
        return lp;
    }

    public post getLatestPost() {
        EntityManager em = emf.createEntityManager();
        post t = em.find(post.class, 3);
        return t;
    }

    public post createpost(post hh) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tt = em.getTransaction();
        try {
            tt.begin();
            em.persist(hh);
            tt.commit();
        } catch (Exception e) {
            tt.rollback();
        }
        return hh;
    }

    public post get(Integer postId) //edit k liae fetch
    {
        EntityManager em = emf.createEntityManager();
        return em.find(post.class, postId);
    }

    public void update(post up) //edit kr k dubara save
    {
        EntityManager em = emf.createEntityManager();
        EntityTransaction emm = em.getTransaction();
        try {
            //System.out.println("naila");
               emm.begin();
               em.merge(up);
                emm.commit();
           }
        catch(Exception er)
        {
            emm.rollback();
        }
    }
    public void delete(String i)
    {EntityManager em=emf.createEntityManager();
    EntityTransaction ty=em.getTransaction();
    try
    {
     ty.begin();
     TypedQuery<post>tpp=em.createQuery("SELECT p FROM post p where title=:title",post.class);
     tpp.setParameter("title",i);
     post op=tpp.getSingleResult();
     em.remove(op);
     ty.commit();
    }
    catch(Exception e)
    {
        ty.rollback();
    }

    }
}
