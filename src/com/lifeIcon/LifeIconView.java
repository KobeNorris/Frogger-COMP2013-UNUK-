package com.lifeIcon;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class LifeIconView extends ImageView {
    private String filePath = "file:resources/img/com/icon-frogger-pixel-512x512.png";

    public LifeIconView(double positionX, double positionY, double size){
        setImage(new Image(this.filePath, size, size, true, true));
        setX(positionX);
        setY(positionY);
    }
}
