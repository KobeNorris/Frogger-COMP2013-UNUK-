package com.platform.turtle;

import com.platform.PlatformController;
import com.platform.PlatformModel;
import javafx.scene.image.Image;
import com.platform.PlatformView;
import gameApp.Main;

public class WetTurtleView extends PlatformView {
    private Image firstFrame, secondFrame, thirdFrame, fourthFrame;
    private PlatformController controller;
    private PlatformModel model;
    private String filePath = "file:resources/img/Platform/Turtle/";

    public WetTurtleView(int positionX, int positionY, double width, double height, double speed) {
        createModel(speed);
        createController();

        this.firstFrame = new Image(this.filePath + "turtleAnimation1.png", width, height, true, true);
        this.secondFrame = new Image(this.filePath + "turtleAnimation2Wet.png", width, height, true, true);
        this.thirdFrame = new Image(this.filePath + "turtleAnimation3Wet.png", width, height, true, true);
        this.fourthFrame = new Image(this.filePath + "turtleAnimation4Wet.png", width, height, true, true);

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
        switch ((int)(timer/600000000 % 4)){
            case 0:
                setImage(this.firstFrame);
                this.model.isSunk = false;
                break;

            case 1:
                setImage(this.secondFrame);
                this.model.isSunk = false;
                break;

            case 2:
                setImage(this.thirdFrame);
                this.model.isSunk = false;
                break;

            case 3:
                setImage(this.fourthFrame);
                this.model.isSunk = true;

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