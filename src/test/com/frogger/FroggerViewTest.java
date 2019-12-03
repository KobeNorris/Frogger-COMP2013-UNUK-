package test.com.frogger;

import code.com.frogger.FroggerView;
import org.junit.Test;

import static org.junit.Assert.*;

public class FroggerViewTest {
    @Test
    public void createModel() {
    }

    @Test
    public void createController() {
    }

    @Test
    public void setBackToStart() {
        FroggerView view = FroggerView.getFroggerView();
        view.setX(10000);
        view.setY(10000);
        view.setBackToStart();
        assertEquals(view.getX(), 280, 0.5);
        assertEquals(view.getY(), 756.9, 0.5);
    }

    @Test
    public void checkStatus() {
        FroggerView view = FroggerView.getFroggerView();
        view.setY(0);
        assertTrue(view.checkStatus(0));
    }

    @Test
    public void resetFroggerModelToStart() {

    }

    @Test
    public void resetPresentHighestPosition() {
    }

    @Test
    public void getPoints() {
    }

    @Test
    public void resetPoints() {
    }

    @Test
    public void getLife() {
    }

    @Test
    public void getStop() {
    }

    @Test
    public void checkScore() {
    }

    @Test
    public void checkLife() {
    }

    @Test
    public void act() {
    }
}