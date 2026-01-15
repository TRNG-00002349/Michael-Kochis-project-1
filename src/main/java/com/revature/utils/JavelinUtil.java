package com.revature.utils;

import com.revature.controlers.*;
import io.javalin.Javalin;

/*
For the Javalin management
 */
public class JavelinUtil {
    public static Javalin server;

    public static Javalin startServer() {
        server = Javalin.create();

        // Set up the server stack
        FollowController followController = new FollowController();
        HealthController healthController = new HealthController();
        TeamController teamController = new TeamController();
        TeamMaskController teamMaskController = new TeamMaskController();
        UserController userController = new UserController();


        //Content Controllers with services and daos.


        //Register API endpopints
        server.get("/ping", healthController::ping);
        server.get("/parrot", healthController::parrot);
        server.get("/api/v1/user/{id}", userController::findUserByID);
        server.get("/api/v1/user", userController::findAllUsers);

        //follow endpoints
        server.post("api/v1/user/follow", followController::createFollow);
        server.delete("api/v1/user/follow", followController::deleteFollow);
        server.get("/api/v1/user/follow/{target}", followController::findFollowsByFollower);
        server.get("/api/v1/user/followed/{target}", followController::findFollowsByFollowed);

        //team endpoints
        server.get("/api/v1/team/{id}", teamController::findTeamById);
        server.post("/api/v1/team", teamController::saveTeam);
        server.put("/api/v1/team", teamController::updateTeam);
        server.delete("/api/v1/team/{id}", teamController::deleteTeam);

        //team-mask endpoints
        server.get("api/v1/teammask/team/{team_id}", teamMaskController::findTeamMaskByTeam);
        server.get("api/v1/teammask/mask/{mask_id}", teamMaskController::findTeamsByMask);
        server.post("/api/v1/teammask", teamMaskController::saveTeamMask);
        server.put("/api/v1/teammask", teamMaskController::updateTeamMask);
        server.delete("/api/v1/teammask", teamMaskController::deleteTeamMask);

        //user enpoints
        server.post("/api/v1/login", userController::userLogon);
        server.post("/api/v1/register", userController::userRegister);
        server.put("/api/v1/user", userController::updateUser);
        server.delete("/api/v1/user/{id}", userController::deleteUser);
        server.get("/api/v1/secure", healthController::secure);


        return server.start(8080);
    }
}
