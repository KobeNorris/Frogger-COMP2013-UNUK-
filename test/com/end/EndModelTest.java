package com.end;

import org.junit.Test;

import static org.junit.Assert.*;

public class EndModelTest {
    EndModel instance = null;

    @Test
    public void getStatus() {
        if(instance == null)
            instance = new EndModel();
        assertEquals(instance.getStatus(), EndModel.Status.EMPTY);
    }

    @Test
    public void setStatus() {
        if(instance == null)
            instance = new EndModel();
        instance.setStatus(EndModel.Status.FROGOCCUPIED);
        assertEquals(instance.getStatus(), EndModel.Status.FROGOCCUPIED);
        instance.setStatus(EndModel.Status.BUGOCCUPIED);
        assertEquals(instance.getStatus(), EndModel.Status.BUGOCCUPIED);
        instance.setStatus(EndModel.Status.CROCOCCUPIED);
        assertEquals(instance.getStatus(), EndModel.Status.CROCOCCUPIED);
        instance.setStatus(EndModel.Status.EMPTY);
        assertEquals(instance.getStatus(), EndModel.Status.EMPTY);
    }

    @Test
    public void frogOccupied() {
        if(instance == null)
            instance = new EndModel();
        instance.setStatus(EndModel.Status.BUGOCCUPIED);
        instance.frogOccupied();
        assertEquals(instance.getStatus(), EndModel.Status.FROGOCCUPIED);
        instance.setStatus(EndModel.Status.CROCOCCUPIED);
        instance.frogOccupied();
        assertEquals(instance.getStatus(), EndModel.Status.FROGOCCUPIED);
        instance.setStatus(EndModel.Status.EMPTY);
        instance.frogOccupied();
        assertEquals(instance.getStatus(), EndModel.Status.FROGOCCUPIED);
    }

    @Test
    public void crocOccupied() {
        if(instance == null)
            instance = new EndModel();
        instance.setStatus(EndModel.Status.FROGOCCUPIED);
        instance.crocOccupied();
        assertEquals(instance.getStatus(), EndModel.Status.CROCOCCUPIED);
        instance.setStatus(EndModel.Status.BUGOCCUPIED);
        instance.crocOccupied();
        assertEquals(instance.getStatus(), EndModel.Status.CROCOCCUPIED);
        instance.setStatus(EndModel.Status.EMPTY);
        instance.crocOccupied();
        assertEquals(instance.getStatus(), EndModel.Status.CROCOCCUPIED);
    }

    @Test
    public void bugOccupied() {
        if(instance == null)
            instance = new EndModel();
        instance.setStatus(EndModel.Status.FROGOCCUPIED);
        instance.bugOccupied();
        assertEquals(instance.getStatus(), EndModel.Status.BUGOCCUPIED);
        instance.setStatus(EndModel.Status.CROCOCCUPIED);
        instance.bugOccupied();
        assertEquals(instance.getStatus(), EndModel.Status.BUGOCCUPIED);
        instance.setStatus(EndModel.Status.EMPTY);
        instance.bugOccupied();
        assertEquals(instance.getStatus(), EndModel.Status.BUGOCCUPIED);
    }

    @Test
    public void setToEmpty() {
        if(instance == null)
            instance = new EndModel();
        instance.setStatus(EndModel.Status.FROGOCCUPIED);
        instance.setToEmpty();
        assertEquals(instance.getStatus(), EndModel.Status.EMPTY);
        instance.setStatus(EndModel.Status.BUGOCCUPIED);
        instance.setToEmpty();
        assertEquals(instance.getStatus(), EndModel.Status.EMPTY);
        instance.setStatus(EndModel.Status.CROCOCCUPIED);
        instance.setToEmpty();
        assertEquals(instance.getStatus(), EndModel.Status.EMPTY);
    }
}