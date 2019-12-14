package com.icon;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * This class is extended from ImageView and applied as the life icon which
 * represents the number of life player has.
 *
 * <p>
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.2
 */
public class LifeIconView extends ImageView {
    private String filePath = "file:resources/img/com/icon-frogger-pixel-512x512.png";

    /**
     * This is the only constructor of lifeIconView, which takes the
     * icon's x position, y position and size of the image. Then, display
     * it to the player.
     *
     * @param positionX The position of life icon in X direction
     * @param positionY The position of life icon in Y direction
     * @param size The size of the image of life icon
     */
    public LifeIconView(double positionX, double positionY, double size){
        setImage(new Image(this.filePath, size, size, true, true));
        setX(positionX);
        setY(positionY);
    }
}
