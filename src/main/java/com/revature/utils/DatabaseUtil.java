package com.revature.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseUtil {
    static Connection conn = null;
    public static Connection getConnection() {

        if( conn == null) {
            try {
                Properties props = new Properties();
                props.load(DatabaseUtil.class.getClassLoader().getResourceAsStream("application.properties"));
                conn = DriverManager.getConnection(
                        props.getProperty("url"), "postgres", props.getProperty("password"));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return conn;
    }
}
