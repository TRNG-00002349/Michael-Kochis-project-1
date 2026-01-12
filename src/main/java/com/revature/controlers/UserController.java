package com.revature.controlers;

import com.revature.daos.UserDAO;
import com.revature.exceptions.UsernameValidationException;
import com.revature.models.User;
import com.revature.services.UserService;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

import com.revature.dtos.LogonDTO;

import java.sql.SQLException;

/*
 * This will handle all the HTTP level request.
 */
public class UserController {
    UserService us;

    public UserController() {
        this.us = new UserService();
    }

    public UserController(UserDAO userDAO) {
        this.us = new UserService(userDAO);
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
