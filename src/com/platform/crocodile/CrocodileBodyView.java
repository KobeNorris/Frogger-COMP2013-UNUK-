package com.platform.crocodile;

import com.platform.PlatformController;
import com.platform.PlatformModel;
import javafx.scene.image.Image;
import com.platform.PlatformView;
import gameApp.Main;

/**
 * This is the view of  Crocodile Body elements in game, extends from Obstacle class
 */
public class CrocodileBodyView extends PlatformView {
    private PlatformModel model;
    private PlatformController controller;
    private String filePath = "file:resources/img/Platform/Crocodile/cro_body.png";

    /**
     * This constructor initialise the position, size and speed of CrocodileBodyView
     *
     * @param positionX CrocodileBodyView's X position
     * @param positionY CrocodileBodyView's Y position
     * @param width  CrocodileBodyView's width
     * @param height CrocodileBodyView's height
     * @param speed  CrocodileBodyView's speed
     */
    public CrocodileBodyView(double positionX, double positionY, double width, double height, double speed) {
        createModel(speed);
        createController();
        setImage(new Image(this.filePath, width, height, true, true));
        setX(positionX);
        setY(positionY);
    }

    @Override
    public boolean isSunk() {return this.model.isSunk;}

    @Override
    public void createModel(double speed){
        this.model = new PlatformModel(speed);
    }

    @Override
    public void createController(){
        this.controller = new PlatformController(this.model);
    }

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
