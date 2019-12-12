package com.platform.crocodile;

import com.platform.PlatformController;
import com.platform.PlatformModel;
import javafx.scene.image.Image;
import com.platform.PlatformView;
import gameApp.Main;

/**
 * This is the view of car elements in game, extends from Obstacle class,
 * it includes two frames in total:
 *      <p>1. Crocodile mouth opened (isSunk == True);
 *      <p>2. Crocodile mouth closed (isSunk == false).
 *
 * <p>
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.2
 */
public class CrocodileHeadView extends PlatformView {
    private Image mouthCloseFrame, mouthOpenFrame;
    private String filePath = "file:resources/img/Platform/Crocodile/";

    /**
     * This constructor initialise the position, size and speed of CrocodileHeadView
     *
     * @param positionX CrocodileHeadView's X position
     * @param positionY CrocodileHeadView's Y position
     * @param size  CrocodileHeadView's size
     * @param speed  CrocodileHeadView's speed
     */
    public CrocodileHeadView(double positionX, double positionY, double size, double speed) {
        createModel(speed);
        createController();

        this.mouthCloseFrame = new Image(this.filePath + "cro_closed.png", size, size, true, true);
        this.mouthOpenFrame = new Image(this.filePath + "cro_open.png", size, size, true, true);

        setX(positionX);
        setY(positionY);
    }

    /**
     * The change frequency of crocodile head animation frames and Sunk status
     *
     * @param timer The value of current time counter
     */
    @Override
    public void swimAction(long timer){
        switch ((int)(timer/600000000 % 2)){
            case 0:
                setImage(this.mouthCloseFrame);
                this.model.setStatus(false);
                break;

            case 1:
                setImage(this.mouthOpenFrame);
                this.model.setStatus(true);
                break;

            default:
        }
    }
}
