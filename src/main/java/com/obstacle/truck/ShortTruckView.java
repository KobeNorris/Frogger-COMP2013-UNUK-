package com.obstacle.truck;

import com.obstacle.ObstacleController;
import com.obstacle.ObstacleModel;
import javafx.scene.image.Image;
import com.obstacle.ObstacleView;
import gameApp.Main;

/**
 * <h1>ShortTruckView</h1>
 *
 * <p> This is the {@link ObstacleView} of short truck elements in game, extends from Obstacle class,
 * it includes two types in total:
 *      <P>1. Left direction short truck;
 *      <p>2. Right direction short truck.
 * <p>
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.4
 * @since 1.0
 * @see ObstacleView
 */
public class ShortTruckView extends ObstacleView {
    private Image ShortTruckLeft, ShortTruckRight;
    private String filePath = "file:src/main/resources/img/Obstacle/Truck/";

    /**
     * This constructor initialise the position, size and speed of ShortTruckView
     *
     * @param positionX ShortTruckView's X position
     * @param positionY ShortTruckView's Y position
     * @param size  ShortTruckView's size
     * @param speed  ShortTruckView's speed
     */
    public ShortTruckView(double positionX, double positionY, double size, double speed) {
        createModel(speed);
        createController();
        ShortTruckRight = new Image(this.filePath + "shortTruckRight.png", size, size, true, true);
        ShortTruckLeft = new Image(this.filePath + "shortTruckLeft.png", size, size, true, true);
        if(speed > 0)
            setImage(ShortTruckRight);
        else
            setImage(ShortTruckLeft);
        setX(positionX);
        setY(positionY);
    }
}
