package com.icon.pauseIcon;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PauseIconView extends ImageView {
    private String filePath = "file:resources/img/com/pause.png";

    public PauseIconView(double positionX, double positionY, double size){
        setImage(new Image(this.filePath, size, size, true, true));
        setX(positionX);
        setY(positionY);
        setVisible(false);
    }
}
