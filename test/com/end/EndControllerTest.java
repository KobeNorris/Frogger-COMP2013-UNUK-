package com.end;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the functionality of EndController
 */
public class EndControllerTest {
    EndController instance = null;

    @Before
    public void initialise(){
        instance = new EndController(new EndModel());
    }

    @Test
    public void setStatus() {
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