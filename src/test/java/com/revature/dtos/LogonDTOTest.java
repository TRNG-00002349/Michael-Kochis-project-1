package com.revature.dtos;

import com.revature.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogonDTOTest {
    private LogonDTO logonDTO;

    @BeforeEach
    //This annotated method will be invoked before each test.
    public void setUp() {
        logonDTO = new LogonDTO();
    }

    @Test
    public void inOutUsername() {
        String testString = "test";
        logonDTO.setUsername(testString);

        assertEquals(testString, logonDTO.getUsername());
    }

    @Test
    public void inOutPassword() {
        String testString = "test";
        logonDTO.setPassword(testString);

        assertEquals(testString, logonDTO.getPassword());
    }

}
