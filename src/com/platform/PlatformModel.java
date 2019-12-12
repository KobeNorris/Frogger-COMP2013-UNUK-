package com.platform;

import com.Model;
import gameApp.Main;

import static java.lang.Math.log;

/**
 * The model of platform
 */
public class PlatformModel implements Model {
    private double originalSpeed;
    private boolean sunk = false;

    public PlatformModel(double speed){
        this.originalSpeed = speed;
        setStatus(false);
    }

    public double getSpeed(){
        return originalSpeed * (1 + log(Main.difficulty)/log(10));
    }

    public boolean isSunk(){
        return sunk;
    }

    public void setStatus(boolean isSunk){
        this.sunk = isSunk;
    }
}
