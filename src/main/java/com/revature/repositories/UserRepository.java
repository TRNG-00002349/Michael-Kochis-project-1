package com.revature.repositories;

import com.revature.models.User;
import com.revature.utils.DatabaseUtil;

import java.sql.*;

public class UserRepository {
    public Connection conn;

    public User saveUser(User user) throws SQLException {
        conn = DatabaseUtil.getConnection();
        String sql = "INSERT INTO p1_user (username, email, password, firstName, lastName) VALUES (?, ?, ?, ?, ?)";

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

    public boolean updateUser(User updateUser) {
        conn = DatabaseUtil.getConnection();

        String sql = "UPDATE p1_user \n" +
                "SET username = ?, " +
                "password = ?," +
                "firstname = ?, " +
                "lastname = ?, " +
                "email = ? \n" +
                "WHERE id = ?;";

        try {
            PreparedStatement prst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            prst.setString(1, updateUser.getUsername());
            prst.setString(2, updateUser.getPassword());
            prst.setString(3, updateUser.getFirstName());
            prst.setString(4, updateUser.getLastName());
            prst.setString(5, updateUser.getEmail());
            prst.setLong(6, updateUser.getId());

            prst.executeUpdate();
        } catch (SQLException e) {
            //TODO: log this instead
            e.printStackTrace();

            return false;
        }

        return true;
    }

    public User findUserByUsername(String username) {
        conn = DatabaseUtil.getConnection();
        User returnThis = null;

        String sql = "SELECT * FROM p1_user WHERE username = ?;";

        try {
            PreparedStatement prst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            prst.setString(1, username);
            ResultSet rs = prst.executeQuery();

            if (rs.next()) {
                returnThis = new User();

                returnThis.setId(rs.getLong("id"));
                returnThis.setUsername(rs.getString("username"));
                returnThis.setPassword(rs.getString("password"));
                returnThis.setEmail(rs.getString("email"));
                returnThis.setFirstName(rs.getString("firstname"));
                returnThis.setLastName(rs.getString("lastname"));
            }
        } catch (SQLException e) {
            // TODO: log the error
            e.printStackTrace();

            return returnThis;
        }

        return returnThis;
    }
}
