package com.revature.controlers;

import com.revature.models.Follow;
import com.revature.services.FollowService;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

import java.util.List;

import java.util.List;

public class FollowController {
    private final FollowService fs;

    public FollowController() {
        this.fs = new FollowService();
    }

    public FollowController(FollowService neoFS) {
        this.fs = neoFS;
    }

    public void createFollow(Context context) {
        Follow follow = context.bodyAsClass(Follow.class);
        Follow returnThis = fs.createFollow(follow.getFollowerId(), follow.getFollowedId());

        if (follow.getFollowerId() == follow.getFollowedId()) {
            context.status(HttpStatus.BAD_REQUEST)
                    .result("You cannot follow yourseelf.");
        } else if (returnThis == null) {
            context.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .result("Something went wrong.");
        } else {
            context.status(HttpStatus.OK)
                    .json(returnThis);
        }
    }

    public void deleteFollow(Context context) {
        Follow targetMe = context.bodyAsClass(Follow.class);

        if (fs.deleteFollow(targetMe.getFollowerId(), targetMe.getFollowedId())) {
            context.status(HttpStatus.OK)
                    .result("Deletion appears to have succeeded.");
        } else {
            context.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .result("Something appears to have gone wrong.");
        }
    }

    public void findFollowsByFollowed(Context context) {
        Long target = context.pathParamAsClass("target", Long.class).get();
        List<Follow> returnThis = fs.findFollowsByFollowed(target);

        if (returnThis == null) {
            context.status(HttpStatus.NO_CONTENT)
                    .result("No such followers found");
        } else {
            context.status(HttpStatus.OK)
                    .json(returnThis);
        }
    }
    public void findFollowsByFollower(Context context) {
        Long target = context.pathParamAsClass("target", Long.class).get();
        List<Follow> returnThis = fs.findFollowsByFollower(target);

        if (returnThis == null) {
            context.status(HttpStatus.NO_CONTENT)
                    .result("No such followers found");
        } else {
            context.status(HttpStatus.OK)
                    .json(returnThis);
        }
    }
}
