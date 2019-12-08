package com.obstacle.snake;

import com.obstacle.ObstacleModel;

public class SnakeModel extends ObstacleModel {
    private String filePath = "file:resources/img/Obstacle/snake/";
    public double speed;

    public SnakeModel(double speed){
        this.speed = speed;
    }

    public String getFilePath(){return this.filePath;}
}
