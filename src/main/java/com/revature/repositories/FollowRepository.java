package com.revature.repositories;

import com.revature.models.Follow;
import com.revature.utils.DatabaseUtil;

import java.sql.*;

public class FollowRepository {
    private Connection conn;

    public FollowRepository() {
    }

    public FollowRepository(Connection neoConn) {
        this.conn = neoConn;
    }

    public Follow createFollow(Long followerId, Long followedId) {
        conn = DatabaseUtil.getConnection();
        Follow returnThis = null;
        String sql = "INSERT INTO follows (follower_id, followed_id) VALUES (?, ?);";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setLong(1, followerId);
            pstmt.setLong(2, followedId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        returnThis = new Follow(followerId, followedId);
        return returnThis;
    }

    public boolean deleteFollow(Long followerId, Long followedId) {
        conn = DatabaseUtil.getConnection();
        String sql = "DELETE FROM follows WHERE follower_id = ? AND followed_id =?;";

        try {
            PreparedStatement prst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            prst.setLong(1, followerId);
            prst.setLong(2, followedId);
            prst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
