package com.obstacle.car;

import com.obstacle.ObstacleModel;

public class CarModel extends ObstacleModel {
    private String filePath = "file:resources/img/Obstacle/car/";
    public double speed;

    public CarModel(double speed){
        this.speed = speed;
    }

    public String getFilePath(){return filePath;}
}
