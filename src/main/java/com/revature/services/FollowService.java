package com.revature.services;

import com.revature.daos.FollowDao;
import com.revature.models.Follow;

import java.util.List;

public class FollowService {
    private final FollowDao followDao;

    public FollowService() {
        this.followDao = new FollowDao();
    }

    public FollowService(FollowDao dao) {
        this.followDao = dao;
    }

    public Follow createFollow(Long follower_Id, Long followed_id) {
        return followDao.createFollow(follower_Id, followed_id);
    }

    public boolean deleteFollow(Long follower_id, Long followed_id) {
        if (follower_id == followed_id) {
            return false;
        }
        return followDao.deleteFollow(follower_id, followed_id);
    }

    public List<Follow> findFollowsByFollower(Long target) {
        return followDao.findFollowsByFollower(target);
    }

    public List<Follow> findFollowsByFollowed(Long target) {
        return followDao.findFollowsByFollowed(target);
    }
}
