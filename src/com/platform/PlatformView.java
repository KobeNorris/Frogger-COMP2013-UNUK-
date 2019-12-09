package com.platform;

import com.View;

public abstract class PlatformView extends View {
    protected PlatformView(){};

    public abstract double getSpeed();

    protected abstract void createModel(double speed);

    protected abstract void createController();

    public abstract boolean isSunk();

    public void act(long timer){};
}