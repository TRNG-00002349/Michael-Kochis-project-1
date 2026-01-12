package com.revature.controlers;

import com.revature.helpers.JSONResponse;

import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import org.jetbrains.annotations.NotNull;

public class HealthController {

    public void ping(Context ctx) {
        JSONResponse response = new JSONResponse("Server is alive");
        ctx.status(HttpStatus.OK);
        ctx.json(response);
    }

    public void parrot(Context ctx) {
        String parrotHears = ctx.body();
        ctx.status(HttpStatus.OK);
        ctx.json(parrotHears);
    }


    public void secure(@NotNull Context context) {
        String token = context.header("Authorization");
        if (token.equals("Vogon poetry is widely known to be the worst poetry in the universe.")) {
            context.status(HttpStatus.OK)
                    .result("Token recognized.");
        } else {
            context.status(HttpStatus.FORBIDDEN)
                    .result("Access token not recognized.");
        }
    }
}
