package com.platform.turtle;

import com.platform.PlatformController;
import com.platform.PlatformModel;
import javafx.scene.image.Image;
import com.platform.PlatformView;
import gameApp.Main;

/**
 * This is the view of dry turtle elements in game, extends from Obstacle class,
 * it includes three frames in total.
 */
public class DryTurtleView extends PlatformView {
    private Image firstFrame, secondFrame, thirdFrame;
    private String filePath = "file:resources/img/Platform/Turtle/";

    /**
     * This constructor initialise the position, size and speed of DryTurtleView
     *
     * @param positionX DryTurtleView's X position
     * @param positionY DryTurtleView's Y position
     * @param size DryTurtleView's size
     * @param speed DryTurtleView's speed
     */
    public DryTurtleView(double positionX, double positionY, double size, double speed) {
        createModel(speed);
        createController();

        this.firstFrame = new Image(this.filePath + "turtleAnimation1.png", size, size, true, true);
        this.secondFrame = new Image(this.filePath + "turtleAnimation2.png", size, size, true, true);
        this.thirdFrame = new Image(this.filePath + "turtleAnimation3.png", size, size, true, true);

        setX(positionX);
        setY(positionY);
    }

    /**
     * The change frequency of dry turtle animation frames
     *
     * @param timer The value of current time counter
     */
    @Override
    public void swimAction(long timer){
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
}
