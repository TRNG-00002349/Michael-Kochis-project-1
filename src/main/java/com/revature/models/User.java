package com.revature.models;

public class User {
    private Long id;  // use UUID when downrange
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;

    public User() {

    }

    public User(long id, String username, String password, String firstName, String lastName
            , String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public User(User otherUser) {
        this.setId(otherUser.getId());
        this.setUsername(otherUser.getUsername());
        this.setPassword(otherUser.getPassword());
        this.setFirstName(otherUser.getFirstName());
        this.setLastName(otherUser.getLastName());
        this.setEmail(otherUser.getEmail());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(Long id, String username, String password, String firstName, String lastName, String email) {
        this.setId(id);
        this.setUsername(username);
        this.setPassword(password);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmail(email);
    }

    public User(String username, String password, String firstName, String lastName, String email) {
        this.setUsername(username);
        this.setPassword(password);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setEmail(email);
    }
}
