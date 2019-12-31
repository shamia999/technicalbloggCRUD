package Blog.Repository;
import Blog.Model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class userRepo
{
       @PersistenceUnit(unitName = "post")
        private EntityManagerFactory emf;
        public void  regis(User uu)
        {

                EntityManager em = emf.createEntityManager();

                EntityTransaction t = em.getTransaction();
              try{
                  t.begin();
                em.persist(uu);
                t.commit();
            }
            catch(Exception ui)
            {
                t.rollback();
            }
        }
        public User checkuser(String username,String password)
        {
            EntityManager e =emf.createEntityManager();
            try {
                TypedQuery<User> tt = e.createQuery("SELECT u FROM User u WHERE u.username =:username AND u.password =:password", User.class);
                tt.setParameter("username", username);
                tt.setParameter("password", password);
                User r = tt.getSingleResult();
                return r;
             }
            catch(NoResultException rr)
            {
                return null;
            }
        }



}
