package com.obstacle.truck;

import com.obstacle.ObstacleController;
import com.obstacle.ObstacleModel;
import javafx.scene.image.Image;
import com.obstacle.ObstacleView;
import gameApp.Main;

/**
 * This is the view of short truck elements in game, extends from Obstacle class,
 * it includes two types in total:
 *      1. Left direction short truck;
 *      2. Right direction short truck.
 */
public class ShortTruckView extends ObstacleView {
    private Image ShortTruckLeft, ShortTruckRight;
    private ObstacleModel model;
    private ObstacleController controller;
    private String filePath = "file:resources/img/Obstacle/Truck/";

    /**
     * This constructor initialise the position, size and speed of ShortTruckView
     *
     * @param shortTruckType Type of the truck
     * @param positionX ShortTruckView's X position
     * @param positionY ShortTruckView's Y position
     * @param size  ShortTruckView's size
     * @param speed  ShortTruckView's speed
     */
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
