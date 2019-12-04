package main.java.com.obstacle.snake;

import main.java.com.obstacle.ObstacleModel;

public class SnakeModel extends ObstacleModel {
    private String filePath = "file:src/main/resources/img/Obstacle/snake/";
    public double speed;

    public SnakeModel(double speed){
        this.speed = speed;
    }

    public String getFilePath(){return this.filePath;}
}
