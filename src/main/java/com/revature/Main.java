package com.revature;

import com.revature.utils.DatabaseUtil;

public class Main {
    public static void main(String[] args) {
        DatabaseUtil.getConnection();
        System.out.println("no error");
    }
}