package com.obstacle;

import com.Model;
import gameApp.Main;

import static java.lang.Math.log;

/**
 * The model of Obstacle
 */
public class ObstacleModel implements Model {
    private double originalSpeed;

    protected ObstacleModel(){}

    public ObstacleModel(double speed){
        this.originalSpeed = speed;
    }

    public double getSpeed(){
        return originalSpeed * (1 + log(Main.difficulty)/log(10));
    }
}
