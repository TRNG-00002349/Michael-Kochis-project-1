package com.revature.repositories;

import com.revature.models.User;
import com.revature.utils.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public Connection conn;

    public boolean deleteUser(Long target) {
        conn = DatabaseUtil.getConnection();
        String sql = "DELETE FROM p1_user WHERE id = ?";

        try {
            PreparedStatement prst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            prst.setLong(1, target);
            prst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

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

    public List<User> findAllUsers() {
        conn = DatabaseUtil.getConnection();
        List<User> returnThis = new ArrayList<>();

        String sql = "SELECT * FROM p1_user;";

        try {
            PreparedStatement prst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = prst.executeQuery();

            while (rs.next()) {
                User tempUser = new User();

                tempUser.setId(rs.getLong("id"));
                tempUser.setUsername(rs.getString("username"));
                tempUser.setPassword("[ENCRYPTED]");
                tempUser.setEmail(rs.getString("email"));
                tempUser.setFirstName(rs.getString("firstname"));
                tempUser.setLastName(rs.getString("lastname"));

                returnThis.add(tempUser);
            }
        } catch (SQLException e) {
            // TODO: log the error
            e.printStackTrace();

            return returnThis;
        }

        return returnThis;
    }

    public User findUserById(Long target) {
        conn = DatabaseUtil.getConnection();
        User returnThis = null;

        String sql = "SELECT * FROM p1_user WHERE id = ?;";

        try {
            PreparedStatement prst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            prst.setLong(1, target);
            ResultSet rs = prst.executeQuery();

            if (rs.next()) {
                returnThis = new User();

                returnThis.setId(rs.getLong("id"));
                returnThis.setUsername(rs.getString("username"));
                returnThis.setPassword("[ENCRYPTED]");
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
