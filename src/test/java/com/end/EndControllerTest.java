package com.end;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Test the functionality of EndController
 */
public class EndControllerTest {
    static EndController instance = null;

    @BeforeAll
    public static void initialise(){
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