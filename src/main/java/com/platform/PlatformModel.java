package main.java.com.platform;

import main.java.com.Model;

public abstract class PlatformModel implements Model {
    public int speed;
    public boolean isSunk = false;

    protected PlatformModel(){};
}
