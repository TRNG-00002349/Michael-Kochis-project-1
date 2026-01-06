package com.revature.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MaskTest {
    private Mask testMask;

    @BeforeEach
    //This annotated method will be invoked before each test.
    public void setUp() {
        testMask = new Mask();
    }

    @Test
    public void instantiateWithID() {
        testMask = new Mask(123L, "testMask", "neuter",
                new StatBlock(3,3,3,3,3,3),
                "");

        assertNotNull(testMask);
    }

    @Test
    public void instantiateWithoutID() {
        testMask = new Mask("testMask", "neuter",
                new StatBlock(3,3,3,3,3,3),
                "");

        assertNotNull(testMask);
    }

    @Test
    public void inOutMaskName() {
        String testString = "testString";
        testMask.setMaskName(testString);

        assertEquals(testString, testMask.getMaskName());
    }

    @Test
    public void inOutGender() {
        String testString = "male";
        testMask.setGender(testString);

        assertEquals(testString, testMask.getGender());
    }

    @Test
    public void inOutImageLink() {
        String testString = "testString";
        testMask.setImageLink(testString);

        assertEquals(testString, testMask.getImageLink());
    }

}
