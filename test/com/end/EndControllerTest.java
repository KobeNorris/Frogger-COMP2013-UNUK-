package com.end;

import org.junit.Test;

import static org.junit.Assert.*;

public class EndControllerTest {
    EndController instance = null;

    @Test
    public void setStatus() {
        if(this.instance == null)
            instance = new EndController(new EndModel());

        instance.setStatus("frog");
        assertEquals(instance.model.getStatus(), EndModel.Status.FROGOCCUPIED);
        instance.setStatus("bug");
        assertEquals(instance.model.getStatus(), EndModel.Status.BUGOCCUPIED);
        instance.setStatus("croc");
        assertEquals(instance.model.getStatus(), EndModel.Status.CROCOCCUPIED);
        instance.setStatus("empty");
        assertEquals(instance.model.getStatus(), EndModel.Status.EMPTY);
    }
}