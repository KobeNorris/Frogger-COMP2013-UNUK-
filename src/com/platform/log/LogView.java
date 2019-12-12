package com.platform.log;

import com.platform.PlatformController;
import com.platform.PlatformModel;
import javafx.scene.image.Image;
import com.platform.PlatformView;
import gameApp.Main;

/**
 * This is the view of log elements in game, extends from Platform class,
 * it includes three types in total:
 *      <p>1. Long;
 *      <p>2. Middle;
 *      <p>3. Short.
 *
 * <p>
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.1
 */
public class LogView extends PlatformView {
    private String filePath = "file:resources/img/Platform/Log/";

    /**
     * This constructor initialise the type, position, size and speed of LogView
     *
     * @param type Type of the log View
     * @param positionX LogView's X position
     * @param positionY LogView's Y position
     * @param size  LogView's size
     * @param speed  LogView's speed
     */
    public LogView(String type, double positionX, double positionY, double size, double speed) {
        createModel(speed);
        createController();

        switch(type){
            case "long":
                setImage(new Image(this.filePath + "longLog.png", size, size, true, true));
                break;

            case "middle":
                setImage(new Image(this.filePath + "middleLog.png", size, size, true, true));
                break;

            case "short":
                setImage(new Image(this.filePath + "shortLog.png", size, size, true, true));
                break;

            default:
        }
        setX(positionX);
        setY(positionY);
    }

    /**
     * Log should have no moving animation
     *
     * @param timer The value of present time counter
     */
    @Override
    protected void swimAction(long timer){}
}
