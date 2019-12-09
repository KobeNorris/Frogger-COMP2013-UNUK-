package com.platform;

import com.View;

/**
 * This is the parent class for all platforms felps player to cross river
 */
public abstract class PlatformView extends View {
    protected PlatformView(){};

    public abstract double getSpeed();

    /**
     * This method initialise the Model of PlatformView
     *
     * @param speed The speed of the element
     */
    protected abstract void createModel(double speed);

    /**
     * This method initialise the Controller of PlatformView=
     */
    protected abstract void createController();

    /**
     * Return whether the PlatformView is sunk
     *
     * @return Whether the PlatformView is sunk
     */
    public abstract boolean isSunk();

    @Override
    public void act(long timer){};
}