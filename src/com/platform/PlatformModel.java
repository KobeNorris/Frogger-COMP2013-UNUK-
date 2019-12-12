package com.platform;

import com.Model;
import gameApp.Main;

import static java.lang.Math.log;

/**
 * The model of platform, containing a method to get the platform's present
 * status and speed.
 *
 * <p>
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.2
 */
public class PlatformModel implements Model {
    private double originalSpeed;
    private boolean sunk = false;

    /**
     * Initialise the speed and status
     *
     * @param speed Primitive speed
     */
    public PlatformModel(double speed){
        this.originalSpeed = speed;
        setStatus(false);
    }

    public double getSpeed(){
        return originalSpeed * (1 + log(Main.difficulty)/log(10));
    }

    /**
     * To check whether the platform is sunk already.
     *
     * @return Whether the platform is sunk already
     */
    public boolean isSunk(){
        return sunk;
    }

    /**
     * Set the status of platform to target status.
     *
     * @param targetStatus Target status
     */
    public void setStatus(boolean targetStatus){
        this.sunk = targetStatus;
    }
}
