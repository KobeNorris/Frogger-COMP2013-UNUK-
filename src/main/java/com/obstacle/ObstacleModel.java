package com.obstacle;

import com.Model;
import gameApp.Main;

import static java.lang.Math.log;

/**
 * <h1>ObstacleModel</h1>
 *
 * <p>The model of Obstacle, containing a method to calculate present element's speed.
 * It extends from {@link Model}
 *
 * <p>
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.4
 * @since 1.0
 * @see Model
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
