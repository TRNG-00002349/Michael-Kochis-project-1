package com.revature.controlers;

import com.revature.helpers.JSONResponse;

import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

public class HealthController {

    public void ping(Context ctx) {
        JSONResponse response = new JSONResponse("Server is alive");
        ctx.status(HttpStatus.OK);
        ctx.json(response);
    }


}
