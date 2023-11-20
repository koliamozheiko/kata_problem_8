package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDaoImp;
import web.model.User;

import java.util.List;
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDaoImp userDaoImp;

    public List<User> getAllUsers() {
        return userDaoImp.getAllUsers();
    }
    @Override
    @Transactional
    public void saveUser(User user) {
        userDaoImp.saveUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        userDaoImp.deleteUser(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDaoImp.updateUser(user);
    }

    @Override
    public User showById(long id) {
        return userDaoImp.showById(id);
    }
}
