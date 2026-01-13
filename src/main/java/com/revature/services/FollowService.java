package com.revature.services;

import com.revature.daos.FollowDao;
import com.revature.models.Follow;

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
        return followDao.deleteFollow(follower_id, followed_id);
    }
}
