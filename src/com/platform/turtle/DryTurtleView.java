package com.platform.turtle;

import com.platform.PlatformController;
import com.platform.PlatformModel;
import javafx.scene.image.Image;
import com.platform.PlatformView;
import gameApp.Main;

public class DryTurtleView extends PlatformView {
    private Image firstFrame, secondFrame, thirdFrame;
    private PlatformController controller;
    private PlatformModel model;
    private String filePath = "file:resources/img/Platform/Turtle/";

    public DryTurtleView(double positionX, double positionY, double width, double height, double speed) {
        createModel(speed);
        createController();

        this.firstFrame = new Image(this.filePath + "turtleAnimation1.png", width, height, true, true);
        this.secondFrame = new Image(this.filePath + "turtleAnimation2.png", width, height, true, true);
        this.thirdFrame = new Image(this.filePath + "turtleAnimation3.png", width, height, true, true);

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

    public void turtleSwim(long timer){
        switch ((int)(timer/600000000 % 3)){
            case 0:
                setImage(this.firstFrame);
                break;

            case 1:
                setImage(this.secondFrame);
                break;

            case 2:
                setImage(this.thirdFrame);
                break;

            default:
        }
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
        turtleSwim(timer);
    }
}
