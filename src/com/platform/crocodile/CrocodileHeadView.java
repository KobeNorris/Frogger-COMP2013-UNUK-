package com.platform.crocodile;

import com.platform.PlatformController;
import com.platform.PlatformModel;
import javafx.scene.image.Image;
import com.platform.PlatformView;
import gameApp.Main;

/**
 * This is the view of car elements in game, extends from Obstacle class,
 * it includes two frames in total:
 *      1. Crocodile mouth opened (isSunk == True);
 *      2. Crocodile mouth closed (isSunk == false).
 */
public class CrocodileHeadView extends PlatformView {
    private Image mouthCloseFrame, mouthOpenFrame;
    private PlatformController controller;
    private PlatformModel model;
    private String filePath = "file:resources/img/Platform/Crocodile/";

    /**
     * This constructor initialise the position, size and speed of CrocodileHeadView
     *
     * @param positionX CrocodileHeadView's X position
     * @param positionY CrocodileHeadView's Y position
     * @param width  CrocodileHeadView's width
     * @param height CrocodileHeadView's height
     * @param speed  CrocodileHeadView's speed
     */
    public CrocodileHeadView(int positionX, int positionY, double width, double height, double speed) {
        createModel(speed);
        createController();

        this.mouthCloseFrame = new Image(this.filePath + "cro_closed.png", width, height, true, true);
        this.mouthOpenFrame = new Image(this.filePath + "cro_open.png", width, height, true, true);

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

    /**
     * The change frequency of crocodile head animation frames and Sunk status
     *
     * @param timer The value of current time counter
     */
    public void CrocodileSwim(long timer){
        switch ((int)(timer/600000000 % 2)){
            case 0:
                setImage(this.mouthCloseFrame);
                this.model.isSunk = false;
                break;

            case 1:
                setImage(this.mouthOpenFrame);
                this.model.isSunk = true;
                break;

            default:
        }
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
        CrocodileSwim(timer);
    }
}
