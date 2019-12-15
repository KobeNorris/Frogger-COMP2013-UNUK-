package com.platform;

import com.View;

/**
 * <h1>PlatformView</h1>
 *
 * <p>This is the parent class for all platforms helps player to cross river. And it extends from {@link View}
 *
 * <p>
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.2
 * @since 1.0
 * @see View
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
    protected void createModel(double speed){
        this.model = new PlatformModel(speed);
    }

    /**
     * This method initialise the Controller of PlatformView
     */
    protected void createController(){
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

    /**
     * The moving action that a platform might have
     *
     * @param timer Value of present timer counter
     */
    protected abstract void swimAction(long timer);

    /**
     * The default act method of PlatformView
     *
     * @param timer Value of present timer counter
     */
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