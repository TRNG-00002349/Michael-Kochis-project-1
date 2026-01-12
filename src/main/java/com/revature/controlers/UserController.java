package com.revature.controlers;

import com.revature.daos.UserDAO;
import com.revature.models.User;
import com.revature.services.UserService;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

import com.revature.dtos.LogonDTO;

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

        context.status(HttpStatus.ACCEPTED);
        context.json(userInfo);
    }
}
