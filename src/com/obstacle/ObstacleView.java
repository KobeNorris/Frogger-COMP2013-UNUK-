package com.obstacle;

import javafx.scene.image.Image;
import com.View;

/**
 * This is the parent class of all obstacle class which could kill the frogger
 * when it touches them
 */
public abstract class ObstacleView extends View {
    protected ObstacleModel model;
    protected ObstacleController controller;

    protected ObstacleView(){}

    /**
     * This method initialise the Model of ObstacleView
     *
     * @param speed The speed of the element
     */
    protected void createModel(double speed){
        this.model = new ObstacleModel(speed);
    }

    /**
     * This method initialise the Controller of ObstacleView=
     */
    protected void createController(){
        this.controller = new ObstacleController(this.model);
    }

    @Override
    public void act(long timer){{
        move(this.model.getSpeed(), 0);
        if (getX() > 700 && this.model.getSpeed() > 0)
            setX(-300);
        else if (getX() < -300 && this.model.getSpeed() < 0)
            setX(700);
    }};
}