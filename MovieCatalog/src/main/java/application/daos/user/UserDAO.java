package application.daos.user;

import application.entities.User;

import java.util.Collection;

public interface UserDAO {
    void saveUser(User user);
    void saveAllUsers(Collection<User> users);
    void updateUser(User user);
}
