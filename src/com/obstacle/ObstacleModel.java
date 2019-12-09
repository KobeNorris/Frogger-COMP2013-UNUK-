package com.obstacle;

import com.Model;

public class ObstacleModel implements Model {
    public double speed;

    protected ObstacleModel(){};

    public ObstacleModel(double speed){
        this.speed = speed;
    }
}
