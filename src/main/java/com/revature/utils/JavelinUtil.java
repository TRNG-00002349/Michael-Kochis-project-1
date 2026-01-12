package com.revature.utils;

import com.revature.controlers.HealthController;
import com.revature.controlers.UserController;
import io.javalin.Javalin;

/*
For the Javalin management
 */
public class JavelinUtil {
    public static Javalin server;

    public static Javalin startServer() {
        server = Javalin.create();

        // Set up the server stack
        HealthController healthController = new HealthController();
        UserController userController = new UserController();

        //Content Controllers with services and daos.


        //Register API endpopints
        server.get("/ping", healthController::ping);
        server.get("/parrot", healthController::parrot);
        server.get("/api/v1/user/{id}", userController::findUserByID);
        server.get("/api/v1/user", userController::findAllUsers);

        //user enpoints
        server.post("/api/v1/login", userController::userLogon);
        server.post("/api/v1/register", userController::userRegister);
        server.put("/api/v1/user", userController::updateUser);
        server.delete("/api/v1/user/{id}", userController::deleteUser);
        server.get("/api/v1/secure", healthController::secure);


        return server.start(8080);
    }
}
