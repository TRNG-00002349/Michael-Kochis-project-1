package com.revature.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    private User user;

    @BeforeEach
    //This annotated method will be invoked before each test.
    public void setUp() {
        user = new User();
    }

    @Test
    public void declarewithVariables() {
        user = new User("test", "password1", "first", "last", "test@test.com");
    }

    @Test
    public void LongIDWorks() {
        Long testID = 123L;

        user.setId(testID);
        assertEquals(testID, user.getId());
    }

    @Test
    public void userNameWorks() {
        String testString = "test";

        user.setUsername(testString);
        assertEquals(testString, user.getUsername());
    }

    @Test
    public void passWordWorks() {
        String testString = "test";

        user.setPassword(testString);
        assertEquals(testString, user.getPassword());
    }

    @Test
    public void firstNameWorks() {
        String testString = "test";

        user.setFirstName(testString);
        assertEquals(testString, user.getFirstName());
    }

    @Test
    public void lastNameWorks() {
        String testString = "test";

        user.setLastName(testString);
        assertEquals(testString, user.getLastName());
    }

    @Test
    public void emailWorks() {
        String testString = "test";

        user.setEmail(testString);
        assertEquals(testString, user.getEmail());
    }



}
