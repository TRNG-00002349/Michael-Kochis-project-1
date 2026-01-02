package com.revature.dtos;

public class LogonDTO {
    private String username;
    private String password;

    public LogonDTO(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public LogonDTO() {
        this.setUsername("");
        this.setPassword("");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
