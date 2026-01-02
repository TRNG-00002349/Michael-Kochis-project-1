package com.revature;

import io.javalin.Javalin;

import com.revature.utils.JavelinUtil;

public class Main {
    public static void main(String[] args) {
        Javalin server = JavelinUtil.startServer();
    }
}