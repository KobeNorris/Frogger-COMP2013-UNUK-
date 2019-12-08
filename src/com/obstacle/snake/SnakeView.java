package com.obstacle.snake;

import javafx.scene.image.Image;
//import Main;
import com.obstacle.ObstacleView;
import gameApp.GameApp;

public class SnakeView extends ObstacleView {
    private Image snake[];
    private int imageIndex = 0, timerInterval = 500;
    private SnakeModel model;
    private SnakeController controller;

    public SnakeView(double positionX, double positionY, double size, double speed) {
        creatSnakeModel(speed);
        creatSnakeController();
        snake = new Image[10];
        for(int iTemp = 0; iTemp < 7; iTemp++){
            snake[iTemp] = new Image(this.model.getFilePath()+"snake"+ (iTemp+1) +".png", size, size, true, true);
        }
        setImage(snake[0]);

        setX(positionX);
        setY(positionY);
    }

    public void creatSnakeModel(double speed){
        this.model = new SnakeModel(speed);
    }

    public void creatSnakeController(){
        this.controller = new SnakeController(this.model);
    }

    @Override
    public void act(long timer) {
        move(this.model.speed  * GameApp.diffficulty, 0);
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
