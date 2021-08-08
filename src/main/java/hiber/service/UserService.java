package hiber.service;

import hiber.model.User;

import java.util.List;


public interface UserService {
    void createUser(User user);

    List<User> listUsers();

    void updateUser(User user);

    void deleteUserById(long id);

    User getUser(long id);

    User getUserByEmail(String email);
}
