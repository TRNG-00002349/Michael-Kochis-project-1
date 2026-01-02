package com.revature.controlers;

import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

public class HealthController {
    public void ping(Context ctx) {
        ctx.status(HttpStatus.OK);
        ctx.result("API responding");
    }


}
