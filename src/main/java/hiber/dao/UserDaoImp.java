package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @PersistenceContext
   private EntityManager em;

   @Override
   public void createUser(User user) {
      em.persist(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      Query query = em.createQuery("SELECT user FROM User user", User.class);
      return query.getResultList();
   }

   @Override
   public void updateUser(User user) {
      em.merge(user);
   }

   @Override
   public void deleteUserById(long id){

      User user = em.find(User.class, id);
      em.remove(user);
   }

   @Override
   public User getUser(long id){
      return em.find(User.class, id);
   }

   @Override
   @SuppressWarnings("unchecked")
   public User getUserByEmail(String email) {
      return em.createQuery("SELECT user FROM User user WHERE user.email=:email", User.class).setParameter("email", email).getSingleResult();
   }


}
