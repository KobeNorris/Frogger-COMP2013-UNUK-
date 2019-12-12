package com.obstacle.truck;

import com.obstacle.ObstacleController;
import com.obstacle.ObstacleModel;
import javafx.scene.image.Image;
import com.obstacle.ObstacleView;
import gameApp.Main;

/**
 * This is the view of long truck elements in game, extends from Obstacle class,
 * it includes two types in total:
 *      <p>1. Left direction long truck;
 *      <p>2. Right direction long truck.
 *
 * <p>
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.4
 */
public class LongTruckView extends ObstacleView {
    private Image LongTruckLeft, LongTruckRight;
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
}
