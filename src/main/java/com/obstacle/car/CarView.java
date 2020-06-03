package com.obstacle.car;

import com.obstacle.ObstacleController;
import com.obstacle.ObstacleModel;
import javafx.scene.image.Image;
import com.obstacle.ObstacleView;
import gameApp.Main;

/**
 * <h1>CarView</h1>
 *
 * <p>This is the {@link ObstacleView} of car elements in game, extends from Obstacle class,
 * it includes two types in total:
 *      <p>1. Car left direction;
 *      <p>2. Car right direction.
 * <br>
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.4
 * @since 1.0
 * @see ObstacleView
 */
public class CarView extends ObstacleView {
    private Image carLeft, carRight;
    private String filePath = "file:src/main/resources/img/Obstacle/car/";

    /**
     * This constructor initialise the position, size and speed of CarView
     *
     * @param positionX CarView's X position
     * @param positionY CarView's Y position
     * @param size  CarView's size
     * @param speed  CarView's speed
     */
    public CarView(double positionX, double positionY, double size, double speed) {
        createModel(speed);
        createController();
        carRight = new Image(this.filePath + "carRight.png", size, size, true, true);
        carLeft = new Image(this.filePath + "carLeft.png", size, size, true, true);
        if(speed > 0)
            setImage(carRight);
        else
            setImage(carLeft);
        setX(positionX);
        setY(positionY);
    }
}
