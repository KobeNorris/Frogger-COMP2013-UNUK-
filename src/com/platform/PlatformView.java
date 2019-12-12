package com.platform;

import com.View;

/**
 * This is the parent class for all platforms felps player to cross river
 */
public abstract class PlatformView extends View {
    protected PlatformController controller;
    protected PlatformModel model;

    protected PlatformView(){};

    public double getSpeed(){
        return this.model.getSpeed();
    }

    /**
     * This method initialise the Model of PlatformView
     *
     * @param speed The speed of the element
     */
    public void createModel(double speed){
        this.model = new PlatformModel(speed);
    }

    /**
     * This method initialise the Controller of PlatformView=
     */
    public void createController(){
        this.controller = new PlatformController(this.model);
    }

    /**
     * Return whether the PlatformView is sunk
     *
     * @return Whether the PlatformView is sunk
     */
    public boolean isSunk(){
        return this.model.isSunk();
    }

    protected abstract void swimAction(long timer);

    @Override
    public void act(long timer){
        move(this.model.getSpeed(), 0);
        if (getX() > 700 && this.model.getSpeed() > 0)
            setX(-300);
        else if (getX() < -300 && this.model.getSpeed() < 0)
            setX(700);
        swimAction(timer);
    }
}