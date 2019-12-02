package code.com;

import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import code.World;

import java.util.ArrayList;

public abstract class View extends ImageView{
    public void manageInput(InputEvent e) {}

    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    public World getWorld() {
        return (World) getParent();
    }

    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }

    public <A extends View> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (A viewer: getWorld().getObjects(cls)) {
            if (viewer != this && viewer.intersects(this.getBoundsInLocal())) {
                someArray.add(viewer);
            }
        }
        return someArray;
    }

    public <A extends View> A getOneIntersectingObject(java.lang.Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (A viewer: getWorld().getObjects(cls)) {
            if (viewer != this && viewer.intersects(this.getBoundsInLocal())) {
                someArray.add(viewer);
                break;
            }
        }
        return someArray.get(0);
    }

    public abstract void act(long timer);
}
