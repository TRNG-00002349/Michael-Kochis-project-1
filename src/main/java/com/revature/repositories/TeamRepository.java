package com.revature.repositories;

import com.revature.models.Team;
import com.revature.utils.DatabaseUtil;

import java.sql.*;

public class TeamRepository {
    private Connection conn;

    public boolean deleteTeam(Long teamId) {
        conn = DatabaseUtil.getConnection();
        String sql = "DELETE FROM team WHERE id = ?";

        try {
            PreparedStatement prst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            prst.setLong(1, teamId);
            prst.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public Team findTeamById(Long target) {
        conn = DatabaseUtil.getConnection();
        Team returnThis = null;

        String sql = "SELECT * FROM team WHERE id = ?;";

        try {
            PreparedStatement prst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            prst.setLong(1, target);
            ResultSet rs = prst.executeQuery();

            if (rs.next()) {
                returnThis = new Team();

                returnThis.setId(rs.getLong("id"));
                returnThis.setOwnerId(rs.getLong("owner_id"));
                returnThis.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            // TODO: log the error
            e.printStackTrace();
            return returnThis;
        }

        return returnThis;
    }

    public Team saveTeam(Team saveThis) {
        conn = DatabaseUtil.getConnection();
        String sql = "INSERT INTO team (owner_id, name) VALUES (?, ?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setLong(1, saveThis.getOwnerId());
            pstmt.setString(2, saveThis.getName());
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                saveThis.setId((long) (rs.getInt("id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return saveThis;
    }

    public boolean updateTeam(Team updateThis) {
        conn = DatabaseUtil.getConnection();

        String sql = "UPDATE team \n" +
                "SET owner_id = ?, " +
                "name = ? \n" +
                "WHERE id = ?;";

        try {
            PreparedStatement prst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            prst.setLong(1, updateThis.getOwnerId());
            prst.setString(2, updateThis.getName());
            prst.setLong(3, updateThis.getId());

            prst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}


