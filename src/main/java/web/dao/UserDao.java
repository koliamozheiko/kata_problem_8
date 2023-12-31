package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);
    void deleteUser(long id);
    void updateUser(User user);
    List<User> getAllUsers();
    User showById(long id);
}
