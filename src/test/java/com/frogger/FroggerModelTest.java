package com.frogger;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <h1>FroggerModelTest</h1>
 *
 * <p>This class will test the functionality of {@link FroggerModel}
 *
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.4
 * @since 1.0
 * @see FroggerModel
 */
public class FroggerModelTest {
    static FroggerModel instance = null;

    /**
     * he instance of Frogger model should be realized first
     */
    @BeforeAll
    public static void initialise(){
        instance = new FroggerModel();
    }

    /**
     * Test the functionality of{@link FroggerModel#setStatus(FroggerModel.Status)}
     */
    @Test
    public void setStatus() {
        instance.setStatus(FroggerModel.Status.ALIVE);
        assertEquals(instance.getStatus(), FroggerModel.Status.ALIVE);
        instance.setStatus(FroggerModel.Status.WATERDEATH);
        assertEquals(instance.getStatus(), FroggerModel.Status.WATERDEATH);
        instance.setStatus(FroggerModel.Status.ROADDEATH);
        assertEquals(instance.getStatus(), FroggerModel.Status.ROADDEATH);
    }

    /**
     * Test the functionality of{@link FroggerModel#getStatus()} 
     */
    @Test
    public void getStatus() {
        instance.setStatus(FroggerModel.Status.ALIVE);
        assertEquals(instance.getStatus(), FroggerModel.Status.ALIVE);
        instance.setStatus(FroggerModel.Status.WATERDEATH);
        assertEquals(instance.getStatus(), FroggerModel.Status.WATERDEATH);
        instance.setStatus(FroggerModel.Status.ROADDEATH);
        assertEquals(instance.getStatus(), FroggerModel.Status.ROADDEATH);
    }

    /**
     * Test the functionality of{@link FroggerModel#getPoints()}
     */
    @Test
    public void getPoints() {
        assertEquals(instance.getPoints(), 0);
    }

    /**
     * Test the functionality of{@link FroggerModel#setPoints(int)}
     */
    @Test
    public void setPoints() {
        instance.setPoints(300);
        assertEquals(instance.getPoints(), 300);
        instance.setPoints(0);
        assertEquals(instance.getPoints(), 0);
    }

    /**
     * Test the functionality of{@link FroggerModel#changePoints(int)} 
     */
    @Test
    public void changePoints() {
        instance.setPoints(0);
        instance.changePoints(300);
        assertEquals(instance.getPoints(), 300);
        instance.changePoints(-300);
        assertEquals(instance.getPoints(), 0);
    }

    /**
     * Test the functionality of{@link FroggerModel#checkScore()} 
     */
    @Test
    public void checkScore() {
        assertFalse(instance.checkScore());
    }

    /**
     * Test the functionality of {@link FroggerModel#checkLife()}
     */
    @Test
    public void checkLife() {
        assertFalse(instance.checkLife());
    }
}