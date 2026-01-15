package com.revature.controlers;

import com.revature.models.TeamMask;
import com.revature.services.TeamMaskService;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

import java.util.List;

public class TeamMaskController {
    private final TeamMaskService tms;

    public TeamMaskController() {
        tms = new TeamMaskService();
    }

    public TeamMaskController(TeamMaskService neo) {
        tms = neo;
    }

    public void findTeamMaskByTeam(Context context) {
        Long targetId = context.pathParamAsClass("team_id", Long.class).get();
        List<TeamMask> list = tms.findTeamMaskByTeam(targetId);

        if (list == null) {
            context.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .result("Something went wrong");
        } else {
            context.status(HttpStatus.OK)
                    .json(list);
        }
    }

    public void findTeamsByMask(Context context) {
        Long targetId = context.pathParamAsClass("mask_id", Long.class).get();
        List<TeamMask> list = tms.findTeamsByMask(targetId);

        if (list == null) {
            context.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .result("Something went wrong");
        } else {
            context.status(HttpStatus.OK)
                    .json(list);
        }
    }

    public void deleteTeamMask(Context context) {
        TeamMask target = context.bodyAsClass(TeamMask.class);
        boolean result = tms.deleteTeamMask(target);

        if (result) {
            context.status(HttpStatus.OK)
                    .result("Mask appears to have been removed from team.");
        } else {
            context.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .result("Something went wrong");
        }
    }

    public void saveTeamMask(Context context) {
        TeamMask target = context.bodyAsClass(TeamMask.class);
        TeamMask result = tms.saveTeamMask(target);

        if (result == null) {
            context.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .result("Something went wrong");
        } else {
            context.status(HttpStatus.OK)
                    .json(result);
        }
    }

    public void updateTeamMask(Context context) {
        context.status(HttpStatus.NOT_IMPLEMENTED)
                .result("This endpoint has no code attached");
    }

}
