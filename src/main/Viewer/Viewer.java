package main.Viewer;

import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import main.World;

import java.util.ArrayList;

public abstract class Viewer extends ImageView{

    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }
}
