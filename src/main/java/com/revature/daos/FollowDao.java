package com.revature.daos;

import com.revature.models.Follow;
import com.revature.repositories.FollowRepository;

import java.util.List;

public class FollowDao {
    private FollowRepository fr = new FollowRepository();
    public Follow createFollow(Long followerId, Long followedId) {
        return fr.createFollow(followerId, followedId);
    }

    public boolean deleteFollow(Long followerId, Long followedId) {
        return fr.deleteFollow(followerId, followedId);
    }

    public List<Follow> findFollowsByFollower(Long target) {
        return fr.findFollowByFollower(target);
    }

    public List<Follow> findFollowsByFollowed(Long target) {
        return fr.findFollowByFollowed(target);
    }
}
