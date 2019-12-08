package com;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

/**
 *
 * Refactor:
 *  The original Actor class, been refactored to View
 *
 */
public abstract class View extends ImageView{
    public void manageInput(InputEvent e) {}

    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    public Pane getWorld() {
        return (Pane) getParent();
    }

    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }

    public <A extends View> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (Node viewer: getWorld().getChildren()) {
            if (viewer != this && viewer.intersects(this.getBoundsInLocal()) && cls.isInstance(viewer)) {
                someArray.add((A)viewer);
            }
        }
        return someArray;
    }

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

    public abstract void act(long timer);
}
