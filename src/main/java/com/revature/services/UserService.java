package com.revature.services;

import com.revature.daos.UserDAO;
import com.revature.exceptions.UsernameValidationException;
import com.revature.models.User;

import java.sql.SQLException;

public class UserService {
    private final UserDAO userDao;

    public UserService() {
        this.userDao = new UserDAO();
    }

    public UserService(UserDAO userDao) {
        this.userDao = userDao;
    }

    public User saveUser(User user) throws UsernameValidationException, SQLException {
        //maybe we do some validation that results in an exception
        if(user.getUsername().length() <= 3) {
            throw new UsernameValidationException("Username must be more than 3 characters.");
        }

        return userDao.saveUser(user);
    }

    public boolean updateUser(User updateUser) {
        return userDao.updateUser(updateUser.getId(), updateUser);
    }

    public boolean updateUser(Long userId, User updateUser) {
        return userDao.updateUser(userId, updateUser);
    }
}
