package com.frogger;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <h1>FroggerControllerTest</h1>
 *
 * <p>Test the functionality of {@link FroggerController}
 *
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.4
 * @since 1.0
 * @see FroggerController
 */
public class FroggerControllerTest {
    static FroggerController instance = null;

    /**
     * The instance of Frogger Controller should be realized first
     */
    @BeforeAll
    public static void initialise(){
        instance = new FroggerController(new FroggerModel());
    }

    /**
     * Test the functionality of {@link FroggerController#revive()}
     */
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

    /**
     * Test the functionality of {@link FroggerController#resetToStart()}
     */
    @Test
    public void resetToStart() {
        instance.resetToStart();
        assertEquals(instance.model.getStatus(), FroggerModel.Status.ALIVE);
        assertFalse(instance.model.noMove);
        assertEquals(instance.model.life, 3);
        assertEquals(instance.model.reachedEnd, 0);
        assertFalse(instance.model.stop);
    }

    /**
     * Test the functionality of {@link FroggerController#bonusPoints()}
     */
    @Test
    public void bonusPoints() {
        int originPoints = instance.model.getPoints();
        instance.bonusPoints();
        assertEquals(instance.model.getPoints(), originPoints + 50);
    }

    /**
     * Test the functionality of {@link FroggerController#blockMove()}
     */
    @Test
    public void blockMove() {
        instance.blockMove();
        assertTrue(instance.model.noMove);
    }
}