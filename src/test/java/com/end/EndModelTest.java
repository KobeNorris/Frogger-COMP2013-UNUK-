package com.end;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <h1>EndModelTest</h1>
 *
 * <p>This class will test the functionality of {@link EndModel}
 *
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.4
 * @since 1.0
 * @see EndModel
 */
public class EndModelTest {
    static EndModel instance = null;

    /**
     * The instance of End Model should be realized first
     */
    @BeforeAll
    public static void initialise(){
        instance = new EndModel();
    }

    /**
     * Test the functionality of {@link EndModel#getStatus()}
     */
    @Test
    public void getStatus() {
        assertEquals(instance.getStatus(), EndModel.Status.EMPTY);
    }

    /**
     * Test the functionality of {@link EndModel#setStatus(EndModel.Status)}
     */
    @Test
    public void setStatus() {
        instance.setStatus(EndModel.Status.FROGOCCUPIED);
        assertEquals(instance.getStatus(), EndModel.Status.FROGOCCUPIED);
        instance.setStatus(EndModel.Status.BUGOCCUPIED);
        assertEquals(instance.getStatus(), EndModel.Status.BUGOCCUPIED);
        instance.setStatus(EndModel.Status.CROCOCCUPIED);
        assertEquals(instance.getStatus(), EndModel.Status.CROCOCCUPIED);
        instance.setStatus(EndModel.Status.EMPTY);
        assertEquals(instance.getStatus(), EndModel.Status.EMPTY);
    }

    /**
     * Test the functionality of {@link EndModel#bugOccupied()} 
     */
    @Test
    public void frogOccupied() {
        instance.setStatus(EndModel.Status.BUGOCCUPIED);
        instance.frogOccupied();
        assertEquals(instance.getStatus(), EndModel.Status.FROGOCCUPIED);
        instance.setStatus(EndModel.Status.CROCOCCUPIED);
        instance.frogOccupied();
        assertEquals(instance.getStatus(), EndModel.Status.FROGOCCUPIED);
        instance.setStatus(EndModel.Status.EMPTY);
        instance.frogOccupied();
        assertEquals(instance.getStatus(), EndModel.Status.FROGOCCUPIED);
        instance.setStatus(EndModel.Status.EMPTY);
    }

    /**
     * Test the functionality of {@link EndModel#frogOccupied()}
     */
    @Test
    public void crocOccupied() {
        instance.setStatus(EndModel.Status.FROGOCCUPIED);
        instance.crocOccupied();
        assertEquals(instance.getStatus(), EndModel.Status.CROCOCCUPIED);
        instance.setStatus(EndModel.Status.BUGOCCUPIED);
        instance.crocOccupied();
        assertEquals(instance.getStatus(), EndModel.Status.CROCOCCUPIED);
        instance.setStatus(EndModel.Status.EMPTY);
        instance.crocOccupied();
        assertEquals(instance.getStatus(), EndModel.Status.CROCOCCUPIED);
        instance.setStatus(EndModel.Status.EMPTY);
    }

    /**
     * Test the functionality of {@link EndModel#bugOccupied()}
     */
    @Test
    public void bugOccupied() {
        instance.setStatus(EndModel.Status.FROGOCCUPIED);
        instance.bugOccupied();
        assertEquals(instance.getStatus(), EndModel.Status.BUGOCCUPIED);
        instance.setStatus(EndModel.Status.CROCOCCUPIED);
        instance.bugOccupied();
        assertEquals(instance.getStatus(), EndModel.Status.BUGOCCUPIED);
        instance.setStatus(EndModel.Status.EMPTY);
        instance.bugOccupied();
        assertEquals(instance.getStatus(), EndModel.Status.BUGOCCUPIED);
        instance.setStatus(EndModel.Status.EMPTY);
    }

    /**
     * Test the functionality of {@link EndModel#setToEmpty()}
     */
    @Test
    public void setToEmpty() {
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