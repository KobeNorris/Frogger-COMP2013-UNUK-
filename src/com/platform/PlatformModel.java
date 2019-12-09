package com.platform;

import com.Model;

/**
 * The model of platform
 */
public class PlatformModel implements Model {
    public double speed;
    public boolean isSunk = false;

    public PlatformModel(double speed){this.speed = speed;}
}
