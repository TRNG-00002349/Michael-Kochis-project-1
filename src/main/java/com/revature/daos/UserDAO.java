package com.revature.daos;

import com.revature.models.User;
import com.revature.repositories.UserRepository;
import com.revature.utils.DatabaseUtil;

import java.sql.*;
import java.util.List;

public class UserDAO {
    private static UserRepository ur;

    public UserDAO() {
        ur = new UserRepository();
    }

    public UserDAO(UserRepository userRepository) {
        ur = userRepository;
    }
    public User saveUser(User user) throws SQLException {
        return ur.saveUser(user);
    }

    public boolean deleteUser(Long target) {
        return ur.deleteUser(target);
    }

    public List<User> findAllUSers() {
        return ur.findAllUsers();
    }

    public User findUserByID(Long target) {
        return ur.findUserById(target);
    }

    public boolean updateUser(User updateUser) {
        return ur.updateUser(updateUser);
    }

    public User findUserByUsername(String username) {
        return ur.findUserByUsername(username);
    }
}
