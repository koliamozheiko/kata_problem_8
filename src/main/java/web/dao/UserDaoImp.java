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
        //entityManager.remove(entityManager.getReference(User.class, id));
        entityManager.createQuery("delete from User where id = : id").setParameter("id", id).executeUpdate();
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);

    }
    @Override
    public User showById(long id) {
        return entityManager.find(User.class, id);
    }


}
