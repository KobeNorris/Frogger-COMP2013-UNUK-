package com.platform;

import com.Model;

public abstract class PlatformModel implements Model {
    public int speed;
    public boolean isSunk = false;

    protected PlatformModel(){};
}
