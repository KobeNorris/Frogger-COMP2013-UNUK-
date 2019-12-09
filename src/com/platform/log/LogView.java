package com.platform.log;

import com.platform.PlatformController;
import com.platform.PlatformModel;
import javafx.scene.image.Image;
import com.platform.PlatformView;
import gameApp.Main;

/**
 * This is the view of log elements in game, extends from Platform class,
 * it includes three types in total:
 *      1. Long;
 *      2. Middle;
 *      3. Short.
 */
public class LogView extends PlatformView {
    private PlatformModel model;
    private PlatformController controller;
    private String filePath = "file:resources/img/Platform/Log/";

    /**
     * This constructor initialise the type, position, size and speed of LogView
     *
     * @param type Type of the log View
     * @param positionX LogView's X position
     * @param positionY LogView's Y position
     * @param width  LogView's width
     * @param height LogView's height
     * @param speed  LogView's speed
     */
    public LogView(String type, double positionX, double positionY, double width, double height, double speed) {
        createModel(speed);
        createController();

        switch(type){
            case "long":
                setImage(new Image(this.filePath + "longLog.png", width, height, true, true));
                break;

            case "middle":
                setImage(new Image(this.filePath + "middleLog.png", width, height, true, true));
                break;

            case "short":
                setImage(new Image(this.filePath + "shortLog.png", width, height, true, true));
                break;

            default:
        }
        setX(positionX);
        setY(positionY);
    }

    @Override
    public void createModel(double speed){
        this.model = new PlatformModel(speed);
    }

    @Override
    public void createController(){
        this.controller = new PlatformController(this.model);
    }

    @Override
    public boolean isSunk(){return this.model.isSunk;}

    @Override
    public double getSpeed(){return this.model.speed;}

    @Override
    public void act(long timer) {
        move(this.model.speed  * Main.diffficulty, 0);
        if (getX() > 700 && this.model.speed > 0)
            setX(-300);
        if (getX() < -300 && this.model.speed < 0)
            setX(700);
    }
}
