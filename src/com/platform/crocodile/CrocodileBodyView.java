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
    private String filePath = "file:resources/img/Platform/Crocodile/cro_body.png";

    /**
     * This constructor initialise the position, size and speed of CrocodileBodyView
     *
     * @param positionX CrocodileBodyView's X position
     * @param positionY CrocodileBodyView's Y position
     * @param size CrocodileBodyView's size
     * @param speed CrocodileBodyView's speed
     */
    public CrocodileBodyView(double positionX, double positionY, double size, double speed) {
        createModel(speed);
        createController();
        setImage(new Image(this.filePath, size, size, true, true));
        setX(positionX);
        setY(positionY);
    }

    @Override
    protected void swimAction(long timer){}
}
