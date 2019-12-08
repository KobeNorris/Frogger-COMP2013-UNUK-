package com.platform.crocodile.crocodileBody;

import javafx.scene.image.Image;
import com.platform.PlatformView;
import gameApp.Main;

public class CrocodileBodyView extends PlatformView {
    private CrocodileBodyModel model;
    private CrocodileBodyController controller;

    public CrocodileBodyView(double positionX, double positionY, double width, double height, double speed) {
        createModel(speed);
        createController();
        setImage(new Image(this.model.getFilePath(), width, height, true, true));
        setX(positionX);
        setY(positionY);
    }

    public void createModel(double speed){
        this.model = new CrocodileBodyModel(speed);
    }

    public void createController(){
        this.controller = new CrocodileBodyController(this.model);
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
