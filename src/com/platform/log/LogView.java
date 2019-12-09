package com.platform.log;

import com.platform.PlatformController;
import com.platform.PlatformModel;
import javafx.scene.image.Image;
import com.platform.PlatformView;
import gameApp.Main;

public class LogView extends PlatformView {
    private PlatformModel model;
    private PlatformController controller;
    private String filePath = "file:resources/img/Platform/Log/";

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
