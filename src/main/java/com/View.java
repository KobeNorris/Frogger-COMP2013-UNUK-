package com;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

/**
 * <h1>View</h1>
 *
 * <P>This class is refactored from original Actor class and is used as the parent class for all
 * game elements.
 *
 *     Refactor:<br>
 *          1. Rename it from Actor to View;<br>
 *          2. Use ArrayList instead of Array to store objects to improve efficiency;<br>
 *          3. Remove methods with little utility.<br>
 *
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.4
 * @since 1.0
 */
public abstract class View extends ImageView{
    /**
     * Move the image's position in stage
     *
     * @param dx The distance of X direction move
     * @param dy The distance of Y direction move
     */
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    /**
     * It returns current Pane's parent
     *
     * @return The Parent of current Pane
     */
    public Pane getWorld() {
        return (Pane) getParent();
    }

    /**
     * It returns current Pane's width
     *
     * @return The width of current Pane
     */
    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    /**
     * It returns current Pane's height
     *
     * @return The height of current Pane
     */
    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }

    /**
     * Get all elements intersected with present View element
     *
     * @param cls Target class
     * @param <A> Target class range
     * @return Array list of intersected elements.
     */
    public <A extends View> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (Node viewer: getWorld().getChildren()) {
            if (viewer != this && viewer.intersects(this.getBoundsInLocal()) && cls.isInstance(viewer)) {
                someArray.add((A)viewer);
            }
        }
        return someArray;
    }

    /**
     * Get the first element intersected with present View element
     *
     * @param cls Target class
     * @param <A> Target class range
     * @return The first intersected element.
     */
    public <A extends View> A getOneIntersectingObject(java.lang.Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (Node viewer: getWorld().getChildren()) {
            if (viewer != this && viewer.intersects(this.getBoundsInLocal()) && cls.isInstance(viewer)) {
                someArray.add((A)viewer);
                break;
            }
        }
        return someArray.get(0);
    }

    /**
     * The action of the View element during the execution of game
     *
     * @param timer Value of present timer counter
     */
    public abstract void act(long timer);
}
