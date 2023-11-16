package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(long id) {
        entityManager.remove(showById(id));
    }

    @Override
    public void updateUser(User user, long id) {
        User userToUpdate = showById(id);
        userToUpdate.setName(user.getName());
        userToUpdate.setLast_name(user.getLast_name());
        userToUpdate.setAge(user.getAge());

    }
    @Override
    public User showById(long id) {
        return entityManager.find(User.class, id);
    }


}
