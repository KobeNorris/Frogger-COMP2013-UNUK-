package main.java.com.platform;

import main.java.com.View;

public abstract class PlatformView extends View {
    protected PlatformView(){};

    public double getSpeed(){return 0.0;};

    public void act(long timer){};
}