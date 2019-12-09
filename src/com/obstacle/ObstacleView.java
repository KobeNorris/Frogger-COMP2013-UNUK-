package com.obstacle;

import javafx.scene.image.Image;
import com.View;

/**
 * This is the parent class of all obstacle class which could kill the frogger
 * when it touches them
 */
public abstract class ObstacleView extends View {
    protected ObstacleView(){}

    /**
     * This method initialise the Model of ObstacleView
     *
     * @param speed The speed of the element
     */
    protected abstract void createModel(double speed);

    /**
     * This method initialise the Controller of ObstacleView=
     */
    protected abstract void createController();

    @Override
    public void act(long timer){};

    public ObstacleView(String imageLink, int positionX, int positionY, double width, double height) {
        setImage(new Image(imageLink, width, height, true, true));
        setX(positionX);
        setY(positionY);
    }
}