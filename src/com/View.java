package com;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

/**
 * This class is refactored from original Actor class and is used as the parent class for all
 * game elements.
 */
public abstract class View extends ImageView{
    /**
     * 
     *
     * @param dx
     * @param dy
     */
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    /**
     *
     *
     * @return
     */
    public Pane getWorld() {
        return (Pane) getParent();
    }

    /**
     *
     *
     * @return
     */
    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    /**
     *
     *
     * @return
     */
    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }

    /**
     *
     *
     * @param cls
     * @param <A>
     * @return
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
     *
     *
     * @param cls
     * @param <A>
     * @return
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
     *
     *
     * @param timer
     */
    public abstract void act(long timer);
}
