package com.revature.controlers;

import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

import com.revature.dtos.LogonDTO;

/*
 * This will handle all the HTTP level request.
 */
public class UserController {
    public void userLogon(Context ctx) {
        LogonDTO logonInfo = ctx.bodyAsClass(LogonDTO.class);
        ctx.status(HttpStatus.OK);
        ctx.json(logonInfo);
    }
}
