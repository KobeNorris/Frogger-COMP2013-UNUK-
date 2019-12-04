package main.java.com.obstacle.car;

import main.java.com.obstacle.ObstacleModel;

public class CarModel extends ObstacleModel {
    private String filePath = "file:src/main/resources/img/Obstacle/car/";
    public double speed;

    public CarModel(double speed){
        this.speed = speed;
    }

    public String getFilePath(){return filePath;}
}
