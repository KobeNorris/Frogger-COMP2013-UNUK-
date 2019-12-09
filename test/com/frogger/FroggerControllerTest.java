package com.frogger;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the functionality of FroggerController
 */
public class FroggerControllerTest {
    FroggerController instance = null;

    @Before
    public void initialise(){
        instance = new FroggerController(new FroggerModel());
    }

    @Test
    public void revive() {
        int lifeNumber = instance.model.life;

        instance.revive();
        assertEquals(instance.model.getStatus(), FroggerModel.Status.ALIVE);
        assertFalse(instance.model.noMove);
        assertTrue(instance.model.changeLife);
        assertEquals(instance.model.getPoints(), 0);
        assertEquals(instance.model.life, lifeNumber - 1);
    }

    @Test
    public void resetToStart() {
        instance.resetToStart();
        assertEquals(instance.model.getStatus(), FroggerModel.Status.ALIVE);
        assertFalse(instance.model.noMove);
        assertEquals(instance.model.life, 3);
        assertEquals(instance.model.reachedEnd, 0);
        assertFalse(instance.model.stop);
    }

    @Test
    public void bonusPoints() {
        int originPoints = instance.model.getPoints();
        instance.bonusPoints();
        assertEquals(instance.model.getPoints(), originPoints + 50);
    }

    @Test
    public void blockMove() {
        instance.blockMove();
        assertTrue(instance.model.noMove);
    }
}