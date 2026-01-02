package com.revature.utils;

import com.revature.controlers.HealthController;
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

        //Content Controllers with services and daos.


        //Register API endpopints
        server.get("/ping", healthController::ping);
        server.get("/parrot", healthController::parrot);


        return server.start(8080);
    }
}
