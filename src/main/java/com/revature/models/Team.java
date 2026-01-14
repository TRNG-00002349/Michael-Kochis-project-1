package com.revature.models;

public class Team {
    private Long id;
    private Long ownerId;
    private String name;

    public Team() {
    }

    public Team(Long id, Long ownerId, String name) {
        this.setId(id);
        this.setOwnerId(ownerId);
        this.setName(name);
    }

    public Team(Team other) {
        this.setId(other.getId());
        this.setOwnerId(other.getOwnerId());
        this.setName(other.getName());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
