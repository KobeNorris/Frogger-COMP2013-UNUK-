package com.obstacle.truck.shortTruck;

import com.obstacle.ObstacleModel;

public class ShortTruckModel extends ObstacleModel {
    private String filePath = "file:resources/img/Obstacle/Truck/";
    public double speed;

    public ShortTruckModel(double speed){
        this.speed = speed;
    }

    public String getFilePath(){return this.filePath;}
}
