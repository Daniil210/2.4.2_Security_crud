package hiber.service;

import hiber.dao.UserDao;
import hiber.dao.UserDaoImp;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

   private final UserDao userDao;
   @Autowired
   public UserServiceImp(UserDao userDao) {
      this.userDao = userDao;
   }


   @Transactional
   @Override
   public void createUser(User user){
      userDao.createUser(user);
   }

   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Transactional
   @Override
   public void updateUser(User user) {
      userDao.updateUser(user);
   }

   @Transactional
   @Override
   public void deleteUserById(long id){
      userDao.deleteUserById(id);
   }

   @Override
   public User getUser(long id) {
      return userDao.getUser(id);
   }

}
