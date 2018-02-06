package application.daos.user;

import application.entities.User;
import application.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null){
            throw new EntityExistsException("User with this name already exist");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        em.persist(user);
        em.flush();
    }

    @Override
    public void saveAllUsers(Collection<User> users) {
        for (User user : users) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            em.persist(user);
            em.flush();
            em.clear();
        }
    }

    @Override
    public void updateUser(User user) {
        em.merge(user);
        em.flush();
    }
}
