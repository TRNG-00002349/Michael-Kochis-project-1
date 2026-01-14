package com.revature.controlers;

import com.revature.daos.UserDAO;
import com.revature.exceptions.UsernameValidationException;
import com.revature.models.User;
import com.revature.services.UserService;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

import com.revature.dtos.LogonDTO;

import java.sql.SQLException;
import java.util.List;

/*
 * This will handle all the HTTP level request.
 */
public class UserController {
    private static UserService us;

    public UserController() {
        this.us = new UserService();
    }

    public UserController(UserDAO userDAO) {
        this.us = new UserService(userDAO);
    }

    public void deleteUser(Context context) {
        Long killMe = context.pathParamAsClass("id", Long.class).get();

        if (us.deleteUser(killMe)) {
            context.status(HttpStatus.OK)
                    .result("User is not in database");
        } else {
            context.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .result("Something went wrong.");
        }
    }

    public void findAllUsers(Context context) {
        List<User> listUsers = us.findAllUsers();

        context.status(HttpStatus.OK)
                .json(listUsers);
    }

    public void findUserByID(Context context) {
        Long findMe = context.pathParamAsClass("id", Long.class).get();

        User returnThis = us.findUserByID(findMe);
        if (returnThis == null) {
            context.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .result("Something went wrong");
        } else {
            context.status(HttpStatus.OK)
                    .json(returnThis);
        }
    }

    public void updateUser(Context ctx) {
        User updateMe = ctx.bodyAsClass(User.class);

        if (us.updateUser(updateMe)) {
            ctx.status(HttpStatus.ACCEPTED)
                    .result("Update appears to have worked.");
        } else {
            ctx.status(HttpStatus.BAD_REQUEST)
                    .result("Something prevented update");
        }
    }

    public void userLogon(Context ctx) {
        LogonDTO logonInfo = ctx.bodyAsClass(LogonDTO.class);
        User loginUser = us.loginUser(logonInfo);

        if (loginUser == null) {
            ctx.status(HttpStatus.UNAUTHORIZED)
                    .result("Invalid username or password.");
        } else {
            loginUser.setPassword("[ENCRYPTED]");
            ctx.status(HttpStatus.OK)
                    .json(loginUser);
        }
    }

    public void userRegister(Context context) {
        User userInfo = context.bodyAsClass(User.class);
        us.encryptUserPassword(userInfo);
        try {
            us.saveUser(userInfo);
        } catch (SQLException e) {
            e.printStackTrace();

            context.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .result("Some SQL Error occurred");
        } catch (UsernameValidationException e) {
            context.status(HttpStatus.BAD_REQUEST)
                    .result("Username did not pass validation criteria");
        }

        context.status(HttpStatus.ACCEPTED);
        context.json(userInfo);
    }
}
