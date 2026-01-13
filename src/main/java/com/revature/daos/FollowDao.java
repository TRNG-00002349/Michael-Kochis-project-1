package com.revature.daos;

import com.revature.models.Follow;
import com.revature.repositories.FollowRepository;

public class FollowDao {
    private FollowRepository fr = new FollowRepository();
    public Follow createFollow(Long followerId, Long followedId) {
        return fr.createFollow(followerId, followedId);
    }

    public boolean deleteFollow(Long followerId, Long followedId) {
        return fr.deleteFollow(followerId, followedId);
    }
}
