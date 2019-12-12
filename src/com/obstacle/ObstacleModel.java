package com.obstacle;

import com.Model;
import gameApp.Main;

import static java.lang.Math.log;

/**
 * The model of Obstacle, containing a method to calculate present element's speed
 *
 * <p>
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.4
 */
public class ObstacleModel implements Model {
    private double originalSpeed;

    protected ObstacleModel(){}

    /**
     * Initialise the primitive speed
     *
     * @param speed Primitive speed
     */
    public ObstacleModel(double speed){
        this.originalSpeed = speed;
    }

    /**
     * Get the speed after the process of adding difficulty
     *
     * @return The processed speed
     */
    public double getSpeed(){
        return originalSpeed * (1 + log(Main.difficulty)/log(10));
    }
}
