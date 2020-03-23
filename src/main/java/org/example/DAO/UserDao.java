package org.example.DAO;

import org.example.model.User;

import java.util.Set;

public interface UserDao {
    User getUser();
    Set<User> getAllUsers();
    User getUserByUserNameAndPassword();
    boolean insertUser();
    boolean updateUser();
    boolean deleteUser();
}
