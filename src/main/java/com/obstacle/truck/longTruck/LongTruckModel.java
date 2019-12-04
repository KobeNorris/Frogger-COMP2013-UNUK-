package main.java.com.obstacle.truck.longTruck;

import main.java.com.obstacle.ObstacleModel;

public class LongTruckModel extends ObstacleModel {
    private String filePath = "file:src/main/resources/img/Obstacle/Truck/";
    public double speed;

    public LongTruckModel(double speed){
        this.speed = speed;
    }

    public String getFilePath(){return this.filePath;}
}
