package com.frogger;

import org.junit.Test;

import static org.junit.Assert.*;

public class FroggerModelTest {
    FroggerModel instance = null;

    @Test
    public void setStatus() {
        if(instance == null)
            instance = new FroggerModel();

        instance.setStatus(FroggerModel.Status.ALIVE);
        assertEquals(instance.getStatus(), FroggerModel.Status.ALIVE);
        instance.setStatus(FroggerModel.Status.WATERDEATH);
        assertEquals(instance.getStatus(), FroggerModel.Status.WATERDEATH);
        instance.setStatus(FroggerModel.Status.ROADDEATH);
        assertEquals(instance.getStatus(), FroggerModel.Status.ROADDEATH);
    }

    @Test
    public void getStatus() {
        if(instance == null)
            instance = new FroggerModel();

        instance.setStatus(FroggerModel.Status.ALIVE);
        assertEquals(instance.getStatus(), FroggerModel.Status.ALIVE);
        instance.setStatus(FroggerModel.Status.WATERDEATH);
        assertEquals(instance.getStatus(), FroggerModel.Status.WATERDEATH);
        instance.setStatus(FroggerModel.Status.ROADDEATH);
        assertEquals(instance.getStatus(), FroggerModel.Status.ROADDEATH);
    }

    @Test
    public void getPoints() {
        if(instance == null)
            instance = new FroggerModel();

        assertEquals(instance.getStatus(), 0);
    }

    @Test
    public void setPoints() {
        if(instance == null)
            instance = new FroggerModel();

        instance.setPoints(300);
        assertEquals(instance.getStatus(), 300);
        instance.setPoints(0);
        assertEquals(instance.getStatus(), 0);
    }

    @Test
    public void changePoints() {
        if(instance == null)
            instance = new FroggerModel();

        instance.setPoints(0);
        instance.changePoints(300);
        assertEquals(instance.getStatus(), 300);
        instance.changePoints(-300);
        assertEquals(instance.getStatus(), 0);
    }

    @Test
    public void checkScore() {
        if(instance == null)
            instance = new FroggerModel();

        assertFalse(instance.checkScore());
    }

    @Test
    public void checkLife() {
        if(instance == null)
            instance = new FroggerModel();
        
        assertFalse(instance.checkLife());
    }
}