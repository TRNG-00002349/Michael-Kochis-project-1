package com.revature.dtos;

public class RegisterDTO {
    private String username;
    private String password;

    public RegisterDTO() {
        this.setUsername("");
        this.setPassword("");
    }

    public RegisterDTO(String userName, String passWord) {
        this.setUsername(userName);
        this.setPassword(passWord);
    }

    public String getPassword() {
        return password;
    }

     public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
