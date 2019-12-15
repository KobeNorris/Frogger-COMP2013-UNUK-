package com.frogger;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test the functionality of FroggerModel
 */
public class FroggerModelTest {
    static FroggerModel instance = null;

    @BeforeAll
    public static void initialise(){
        instance = new FroggerModel();
    }

    @Test
    public void setStatus() {
        instance.setStatus(FroggerModel.Status.ALIVE);
        assertEquals(instance.getStatus(), FroggerModel.Status.ALIVE);
        instance.setStatus(FroggerModel.Status.WATERDEATH);
        assertEquals(instance.getStatus(), FroggerModel.Status.WATERDEATH);
        instance.setStatus(FroggerModel.Status.ROADDEATH);
        assertEquals(instance.getStatus(), FroggerModel.Status.ROADDEATH);
    }

    @Test
    public void getStatus() {
        instance.setStatus(FroggerModel.Status.ALIVE);
        assertEquals(instance.getStatus(), FroggerModel.Status.ALIVE);
        instance.setStatus(FroggerModel.Status.WATERDEATH);
        assertEquals(instance.getStatus(), FroggerModel.Status.WATERDEATH);
        instance.setStatus(FroggerModel.Status.ROADDEATH);
        assertEquals(instance.getStatus(), FroggerModel.Status.ROADDEATH);
    }

    @Test
    public void getPoints() {
        assertEquals(instance.getPoints(), 0);
    }

    @Test
    public void setPoints() {
        instance.setPoints(300);
        assertEquals(instance.getPoints(), 300);
        instance.setPoints(0);
        assertEquals(instance.getPoints(), 0);
    }

    @Test
    public void changePoints() {
        instance.setPoints(0);
        instance.changePoints(300);
        assertEquals(instance.getPoints(), 300);
        instance.changePoints(-300);
        assertEquals(instance.getPoints(), 0);
    }

    @Test
    public void checkScore() {
        assertFalse(instance.checkScore());
    }

    @Test
    public void checkLife() {
        assertFalse(instance.checkLife());
    }
}