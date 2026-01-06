package com.revature.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StatBlockTest {
    private StatBlock statBlock;

    @BeforeEach
    //This annotated method will be invoked before each test.
    public void setUp() {
        statBlock = new StatBlock();
    }

    @Test
    public void instantiateWithoutID() {
        statBlock = new StatBlock(3, 3, 3, 3, 3, 3);

        assertNotNull(statBlock);
    }

    @Test
    public void instantiateWithID() {
        statBlock = new StatBlock(123L, 3, 3, 3, 3, 3, 3);

        assertNotNull(statBlock);
    }

    @Test
    public void inOutID() {
        Long testID = 123L;
        statBlock.setId(testID);

        assertEquals(testID, statBlock.getId());
    }

    @Test
    public void inOutMight() {
        int testStat = 5;
        statBlock.setMight(testStat);

        assertEquals(testStat, statBlock.getMight());
    }

    @Test
    public void inOutAgility() {
        int testStat = 3;
        statBlock.setAgility(testStat);

        assertEquals(testStat, statBlock.getAgility());
    }

    @Test
    public void inOutValor() {
        int testStat = 3;
        statBlock.setValor(testStat);

        assertEquals(testStat, statBlock.getValor());
    }

    @Test
    public void inOutResolve() {
        int testStat = 3;
        statBlock.setResolve(testStat);

        assertEquals(testStat, statBlock.getResolve());
    }

    @Test
    public void inOutInsight() {
        int testStat = 3;
        statBlock.setInsight(testStat);

        assertEquals(testStat, statBlock.getInsight());
    }

    @Test
    public void inOutCharisma() {
        int testStat = 3;
        statBlock.setCharisma(testStat);

        assertEquals(testStat, statBlock.getCharisma());
    }

}
