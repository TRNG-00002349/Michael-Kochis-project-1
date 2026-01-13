package com.revature.models;

public class Follow {
    private Long followerId;
    private Long followedId;

    public Follow() {
        this.setFollowerId(0L);
        this.setFollowedId(0L);
    }

    public Follow(Long followerId, Long followedId) {
        this.setFollowerId(followerId);
        this.setFollowedId(followedId);
    }

    public Long getFollowerId() {
        return followerId;
    }

    public void setFollowerId(Long followerId) {
        this.followerId = followerId;
    }

    public Long getFollowedId() {
        return followedId;
    }

    public void setFollowedId(Long followedId) {
        this.followedId = followedId;
    }
}
