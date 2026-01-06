package com.revature.dtos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterDTOTest {
    private RegisterDTO registerDTO;

    @BeforeEach
    //This annotated method will be invoked before each test.
    public void setUp() {
        registerDTO = new RegisterDTO();
    }

    @Test
    public void inOutUsername() {
        String testString = "test";
        registerDTO.setUsername(testString);

        assertEquals(testString, registerDTO.getUsername());
    }

    @Test
    public void inOutPassword() {
        String testString = "test";
        registerDTO.setPassword(testString);

        assertEquals(testString, registerDTO.getPassword());
    }
}
