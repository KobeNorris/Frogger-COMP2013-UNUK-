package com.obstacle.truck;

import com.obstacle.ObstacleController;
import com.obstacle.ObstacleModel;
import javafx.scene.image.Image;
import com.obstacle.ObstacleView;
import gameApp.Main;

public class ShortTruckView extends ObstacleView {
    private Image ShortTruckLeft, ShortTruckRight;
    private ObstacleModel model;
    private ObstacleController controller;
    private String filePath = "file:resources/img/Obstacle/Truck/";

    public ShortTruckView(String shortTruckType, double positionX, double positionY, double size, double speed) {
        createModel(speed);
        createController();
        ShortTruckRight = new Image(this.filePath + "shortTruckRight.png", size, size, true, true);
        ShortTruckLeft = new Image(this.filePath + "shortTruckLeft.png", size, size, true, true);
        if(shortTruckType.equals("right"))
            setImage(ShortTruckRight);
        else
            setImage(ShortTruckLeft);
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
        move(this.model.speed  * Main.diffficulty , 0);
        if (getX() > 700 && this.model.speed > 0)
            setX(-300);
        if (getX() < -300 && this.model.speed < 0)
            setX(700);
    }
}
