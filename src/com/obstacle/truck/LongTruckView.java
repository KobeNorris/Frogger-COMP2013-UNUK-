package com.obstacle.truck;

import com.obstacle.ObstacleController;
import com.obstacle.ObstacleModel;
import javafx.scene.image.Image;
import com.obstacle.ObstacleView;
import gameApp.Main;

/**
 * This is the view of long truck elements in game, extends from Obstacle class,
 * it includes two types in total:
 *      1. Left direction long truck;
 *      2. Right direction long truck.
 */
public class LongTruckView extends ObstacleView {
    private Image LongTruckLeft, LongTruckRight;
    private ObstacleModel model;
    private ObstacleController controller;
    private String filePath = "file:resources/img/Obstacle/Truck/";

    /**
     * This constructor initialise the type, position, size and speed of LongTruckView
     *
     * @param longTruckType Type of the truck
     * @param positionX LongTruckView's X position
     * @param positionY LongTruckView's Y position
     * @param size  LongTruckView's size
     * @param speed  LongTruckView's speed
     */
    public LongTruckView(String longTruckType, double positionX, double positionY, double size, double speed) {
        createModel(speed);
        createController();
        LongTruckRight = new Image(this.filePath + "longTruckRight.png", size, size, true, true);
        LongTruckLeft = new Image(this.filePath + "longTruckLeft.png", size, size, true, true);
        if(longTruckType.equals("right"))
            setImage(LongTruckRight);
        else
            setImage(LongTruckLeft);
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
    }
}
