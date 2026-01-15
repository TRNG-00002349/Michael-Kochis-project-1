package com.revature.repositories;

import com.revature.models.TeamMask;
import com.revature.utils.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeamMaskRepository {
    private static Connection conn;

    public TeamMaskRepository() {
        conn = DatabaseUtil.getConnection();
    }

    public TeamMaskRepository(Connection neo) {
        conn = neo;
    }

    public List<TeamMask> findTeamMaskByTeam(Long teamId) {
        String sql = "SELECT * FROM teammask WHERE team_id = ?;";
        List<TeamMask> returnThis = null;

        try {
            PreparedStatement prst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            prst.setLong(1, teamId);
            prst.executeQuery();

            ResultSet rs = prst.getResultSet();
            returnThis = teamMaskFromResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return returnThis;
        }

        return returnThis;
    }


    public List<TeamMask> findTeamsByMask(Long maskId){
        String sql = "SELECT * FROM teammask WHERE mask_id = ?;";
        List<TeamMask> returnThis = null;

        try {
            PreparedStatement prst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            prst.setLong(1, maskId);
            prst.executeQuery();

            ResultSet rs = prst.getResultSet();
            returnThis = teamMaskFromResultSet(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            return returnThis;
        }

        return returnThis;

    }

    public boolean deleteTeamMask(TeamMask target) {
        String sql = "DELETE FROM teammask WHERE team_id = ? AND mask_id =?;";

        try {
            PreparedStatement prst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            prst.setLong(1, target.getTeamId());
            prst.setLong(2, target.getMaskId());
            prst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public TeamMask saveTeamMask(TeamMask saveMe) {
        String sql = "INSERT INTO teammask (team_id, mask_id, role) VALUES (?, ?, ?);";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setLong(1, saveMe.getTeamId());
            pstmt.setLong(2, saveMe.getMaskId());
            pstmt.setString(3, saveMe.getRole());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return saveMe;    }

    private List<TeamMask> teamMaskFromResultSet(ResultSet rs) {
        List<TeamMask> returnThis = new ArrayList<>();

        try {
            while (rs.next()) {
                TeamMask temp = new TeamMask();
                temp.setTeamId(rs.getLong("team_id"));
                temp.setMaskId(rs.getLong("mask_id"));
                temp.setRole(rs.getString("role"));

                returnThis.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return returnThis;
        }

        return returnThis;
    }


    public boolean updateTeamMask(TeamMask updateMe) {
        //TODO: implement if needed
        return false;
    }
}
