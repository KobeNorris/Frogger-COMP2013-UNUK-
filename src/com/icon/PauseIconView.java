package com.icon;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class is extends from ImageView and applied to represent
 * the pause status of the game
 *
 * <br>
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.2
 */
public class PauseIconView extends ImageView {
    private String filePath = "file:resources/img/com/pause.png";

    /**
     * This is the only constructor of PauseIconView, which takes the
     * icon's x position, y position and size of the image. Then, display
     * it to the player.
     *
     * @param positionX The position of pause icon in X direction
     * @param positionY The position of pause icon in Y direction
     * @param size The size of the image of pause icon
     */
    public PauseIconView(double positionX, double positionY, double size){
        setImage(new Image(this.filePath, size, size, true, true));
        setX(positionX);
        setY(positionY);
        setVisible(false);
    }
}
