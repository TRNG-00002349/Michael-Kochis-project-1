package com.revature.models;

public class TeamMask {
    private Long teamId;
    private Long maskId;
    private String role;

    public TeamMask() {
    }

    public TeamMask(Long teamId, Long maskId, String role) {
        this.setTeamId(teamId);
        this.setMaskId(maskId);
        this.setRole(role);
    }

    public TeamMask(TeamMask other) {
        this.setTeamId(other.getTeamId());
        this.setMaskId(other.getMaskId());
        this.setRole(other.getRole());
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getMaskId() {
        return maskId;
    }

    public void setMaskId(Long maskId) {
        this.maskId = maskId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
