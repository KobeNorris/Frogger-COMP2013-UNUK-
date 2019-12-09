package com.obstacle.car;

import com.obstacle.ObstacleController;
import com.obstacle.ObstacleModel;
import javafx.scene.image.Image;
import com.obstacle.ObstacleView;
import gameApp.Main;

public class CarView extends ObstacleView {
    private Image carLeft, carRight;
    private ObstacleModel model;
    private ObstacleController controller;
    private String filePath = "file:resources/img/Obstacle/car/";
    
    public CarView(String carType, double positionX, double positionY, double size, double speed) {
        createModel(speed);
        createController();
        carRight = new Image(this.filePath + "carRight.png", size, size, true, true);
        carLeft = new Image(this.filePath + "carLeft.png", size, size, true, true);
        if(carType.equals("right"))
            setImage(carRight);
        else
            setImage(carLeft);
        setX(positionX);
        setY(positionY);
    }

    @Override
    protected void createModel(double speed){
        this.model = new ObstacleModel(speed);
    }

    @Override
    protected void createController(){
        this.controller = new ObstacleController(this.model);
    }

    @Override
    public void act(long timer) {
        move(this.model.speed  * Main.diffficulty, 0);
        if (getX() > 700 && this.model.speed > 0)
            setX(-300);
        if (getX() < -300 && this.model.speed < 0)
            setX(700);
    }
}
