package main.java.com.obstacle.truck.shortTruck;

import main.java.com.obstacle.ObstacleModel;

public class ShortTruckModel extends ObstacleModel {
    private String filePath = "file:src/main/resources/img/Obstacle/Truck/";
    public double speed;

    public ShortTruckModel(double speed){
        this.speed = speed;
    }

    public String getFilePath(){return this.filePath;}
}
