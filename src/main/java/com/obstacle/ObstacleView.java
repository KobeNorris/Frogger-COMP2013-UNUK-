package com.obstacle;

import javafx.scene.image.Image;
import com.View;

/**
 * <h1>ObstacleView</h1>
 *
 * <p>This is the parent class of all obstacle class which could kill the frogger
 * when it touches them. It extends from {@link View} and connected with
 * {@link ObstacleModel} and {@link ObstacleController}
 *
 * <p>
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.4
 * @since 1.0
 * @see View
 * @see ObstacleModel
 * @see ObstacleController
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