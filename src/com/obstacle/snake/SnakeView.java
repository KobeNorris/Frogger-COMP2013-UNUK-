package com.obstacle.snake;

import com.obstacle.ObstacleController;
import com.obstacle.ObstacleModel;
import javafx.scene.image.Image;
//import Main;
import com.obstacle.ObstacleView;
import gameApp.Main;

public class SnakeView extends ObstacleView {
    private Image snake[];
    private int imageIndex = 0, timerInterval = 500;
    private ObstacleModel model;
    private ObstacleController controller;
    private String filePath = "file:resources/img/Obstacle/snake/";

    public SnakeView(double positionX, double positionY, double size, double speed) {
        createModel(speed);
        createController();
        snake = new Image[10];
        for(int iTemp = 0; iTemp < 7; iTemp++){
            snake[iTemp] = new Image(this.filePath + "snake"+ (iTemp+1) +".png", size, size, true, true);
        }
        setImage(snake[0]);

        setX(positionX);
        setY(positionY);
    }

    @Override
    public void createModel(double speed){
        this.model = new ObstacleModel(speed);
    }

    @Override
    public void createController(){
        this.controller = new ObstacleController(this.model);
    }

    @Override
    public void act(long timer) {
        move(this.model.speed  * Main.diffficulty, 0);
        if (getX() > 700 && this.model.speed > 0)
            setX(-300);
        if (getX() < -300 && this.model.speed < 0)
            setX(700);
        if(timer % timerInterval == 0){
            if(imageIndex >= 6)
                imageIndex = 0;
            else
                imageIndex++;
            setImage(snake[imageIndex]);
        }
    }
}
