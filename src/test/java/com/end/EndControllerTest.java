package com.end;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * <h1>EndControllerTest</h1>
 *
 * <p>This class will test the functionality of {@link EndController}
 *
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.4
 * @since 1.0
 * @see EndController
 */
public class EndControllerTest {
    static EndController instance = null;

    /**
     * The instance of End Controller should be realized first
     */
    @BeforeAll
    public static void initialise(){
        instance = new EndController(new EndModel());
    }

    /**
     * To test the functionality of {@link EndController#setStatus(String)}
     */
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