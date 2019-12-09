package com.frogger;

import org.junit.Test;

import static org.junit.Assert.*;

public class FroggerControllerTest {
    FroggerController instance = null;

    @Test
    public void revive() {
        if(instance == null)
            instance = new FroggerController(new FroggerModel());

        instance.revive();
        assertEquals(instance.model.getStatus(), FroggerModel.Status.ALIVE);
        assertFalse(instance.model.noMove);
        assertTrue(instance.model.changeLife);
        assertEquals(instance.model.getPoints(), 0);
        assertEquals(instance.model.life, 3);
    }

    @Test
    public void resetToStart() {
        if(instance == null)
            instance = new FroggerController(new FroggerModel());

        instance.resetToStart();
        assertEquals(instance.model.getStatus(), FroggerModel.Status.ALIVE);
        assertFalse(instance.model.noMove);
        assertEquals(instance.model.life, 3);
        assertEquals(instance.model.reachedEnd, 0);
        assertFalse(instance.model.stop);
    }

    @Test
    public void bonusPoints() {
        if(instance == null)
            instance = new FroggerController(new FroggerModel());

        int originPoints = instance.model.getPoints();
        instance.bonusPoints();
        assertEquals(instance.model.getPoints(), originPoints + 50);
    }

    @Test
    public void blockMove() {
        if(instance == null)
            instance = new FroggerController(new FroggerModel());

        instance.blockMove();
        assertFalse(instance.model.noMove);
    }
}