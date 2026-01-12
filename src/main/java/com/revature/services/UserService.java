package com.revature.services;

import com.revature.daos.UserDAO;
import com.revature.dtos.LogonDTO;
import com.revature.dtos.RegisterDTO;
import com.revature.exceptions.UsernameValidationException;
import com.revature.models.User;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;

public class UserService {
    private final UserDAO userDao;

    public UserService() {
        this.userDao = new UserDAO();
    }

    public UserService(UserDAO userDao) {
        this.userDao = userDao;
    }

    public boolean encryptUserPassword(User user) {
        String salt = BCrypt.gensalt(12);

        // Hash the password
        String hashed = BCrypt.hashpw(user.getPassword(), salt);
        user.setPassword(hashed);

        return true;
    }

    public User saveUser(User user) throws UsernameValidationException, SQLException {
        //maybe we do some validation that results in an exception
        if(user.getUsername().length() <= 3) {
            throw new UsernameValidationException("Username must be more than 3 characters.");
        }

        return userDao.saveUser(user);
    }

    public boolean updateUser(User updateUser) {
        encryptUserPassword(updateUser);

        return userDao.updateUser(updateUser);
    }

    public User loginUser(LogonDTO logonInfo) {
        User returnThis = userDao.findUserByUsername(logonInfo.getUsername());

        //TODO: check the password here
        if (BCrypt.checkpw(logonInfo.getPassword(), returnThis.getPassword())) {
            return returnThis;
        } else {
            return null;
        }
    }
}
