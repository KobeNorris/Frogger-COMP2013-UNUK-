package com.obstacle;

import com.Model;

public abstract class ObstacleModel implements Model {
    public double speed;

    protected ObstacleModel(){};

    public ObstacleModel(double speed){
        this.speed = speed;
    }
}
