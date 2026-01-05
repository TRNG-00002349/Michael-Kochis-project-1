package com.revature.repositories;

import com.revature.models.User;
import com.revature.utils.DatabaseUtil;

import java.sql.*;

public class UserRepository {
    public Connection conn;

    public User saveUser(User user) throws SQLException {
        conn = DatabaseUtil.getConnection();
        String sql = "INSERT INTO p1_users (username, email, password, first_name, last_name) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getEmail());
        pstmt.setString(3, user.getPassword());
        pstmt.setString(4, user.getFirstName());
        pstmt.setString(5, user.getLastName());
        pstmt.executeUpdate();

        ResultSet rs = pstmt.getGeneratedKeys();
        if(rs.next()) {
            user.setId((long)(rs.getInt("id")));
        }

        return user;
    }
}
