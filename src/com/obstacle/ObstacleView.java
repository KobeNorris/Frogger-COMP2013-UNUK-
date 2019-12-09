package com.obstacle;

import javafx.scene.image.Image;
import com.View;

public abstract class ObstacleView extends View {
    protected ObstacleView(){}

    protected abstract void createModel(double speed);

    protected abstract void createController();

    @Override
    public void act(long timer){};

    public ObstacleView(String imageLink, int positionX, int positionY, double width, double height) {
        setImage(new Image(imageLink, width, height, true, true));
        setX(positionX);
        setY(positionY);
    }
}