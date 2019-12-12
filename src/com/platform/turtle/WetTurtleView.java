package com.platform.turtle;

import com.platform.PlatformController;
import com.platform.PlatformModel;
import javafx.scene.image.Image;
import com.platform.PlatformView;
import gameApp.Main;

/**
 * This is the view of wet turtle elements in game, extends from Obstacle class,
 * it includes four frames in total.
 */
public class WetTurtleView extends PlatformView {
    private Image firstFrame, secondFrame, thirdFrame, fourthFrame;
    private String filePath = "file:resources/img/Platform/Turtle/";

    /**
     * This constructor initialise the position, size and speed of WetTurtleView
     *
     * @param positionX WetTurtleView's X position
     * @param positionY WetTurtleView's Y position
     * @param size  WetTurtleView's size
     * @param speed  WetTurtleView's speed
     */
    public WetTurtleView(double positionX, double positionY, double size, double speed) {
        createModel(speed);
        createController();

        this.firstFrame = new Image(this.filePath + "turtleAnimation1.png", size, size, true, true);
        this.secondFrame = new Image(this.filePath + "turtleAnimation2Wet.png", size, size, true, true);
        this.thirdFrame = new Image(this.filePath + "turtleAnimation3Wet.png", size, size, true, true);
        this.fourthFrame = new Image(this.filePath + "turtleAnimation4Wet.png", size, size, true, true);

        setX(positionX);
        setY(positionY);
    }

    /**
     * The change frequency of wet turtle animation frames and isSunk status
     *
     * @param timer The value of current time counter
     */
    @Override
    public void swimAction(long timer){
        switch ((int)(timer/600000000 % 4)){
            case 0:
                setImage(this.firstFrame);
                this.model.setStatus(false);
                break;

            case 1:
                setImage(this.secondFrame);
                this.model.setStatus(false);
                break;

            case 2:
                setImage(this.thirdFrame);
                this.model.setStatus(false);
                break;

            case 3:
                setImage(this.fourthFrame);
                this.model.setStatus(true);

            default:
        }
    }
}