package com.revature.controlers;

import com.revature.daos.TeamDao;
import com.revature.exceptions.UsernameValidationException;
import com.revature.models.Team;
import com.revature.models.User;
import com.revature.services.TeamService;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

import java.sql.SQLException;

public class TeamController {
    private static TeamService ts;

    public TeamController() {
        ts = new TeamService();
    }

    public TeamController(TeamService neo) {
        ts = neo;
    }

    public TeamController(TeamDao td) {
        ts = new TeamService(td);
    }

    public void deleteTeam(Context context) {
        Long killMe = context.pathParamAsClass("id", Long.class).get();

        if (ts.deleteTeam(killMe)) {
            context.status(HttpStatus.OK)
                    .result("Team is not in database");
        } else {
            context.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .result("Something went wrong.");
        }
    }

    public void findTeamById(Context context) {
        Long findMe = context.pathParamAsClass("id", Long.class).get();

        Team returnThis = ts.findTeamByID(findMe);
        if (returnThis == null) {
            context.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .result("Something went wrong");
        } else {
            context.status(HttpStatus.OK)
                    .json(returnThis);
        }
    }

    public void saveTeam(Context context) {
        Team teamInfo = context.bodyAsClass(Team.class);

        ts.saveTeam(teamInfo);

        if (teamInfo == null) {
            context.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .result("Some SQL Error occurred");
        } else {
            context.status(HttpStatus.ACCEPTED);
            context.json(teamInfo);
        }
    }


    public void updateTeam(Context ctx) {
        Team updateMe = ctx.bodyAsClass(Team.class);

        if (ts.updateTeam(updateMe)) {
            ctx.status(HttpStatus.ACCEPTED)
                    .result("Update appears to have worked.");
        } else {
            ctx.status(HttpStatus.BAD_REQUEST)
                    .result("Something prevented update");
        }
    }

}
