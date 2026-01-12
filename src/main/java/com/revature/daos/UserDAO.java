package com.revature.daos;

import com.revature.models.User;
import com.revature.repositories.UserRepository;
import com.revature.utils.DatabaseUtil;

import java.sql.*;

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

    public boolean updateUser(User updateUser) {
        return updateUser(updateUser.getId(), updateUser);
    }

    public boolean updateUser(Long userId, User updateUser) {
        return ur.updateUser(userId, updateUser);
    }

    public User findUserByUsername(String username) {
        return ur.findUserByUsername(username);
    }
}
