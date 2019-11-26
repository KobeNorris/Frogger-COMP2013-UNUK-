package main.Element.Platform;

import javafx.scene.image.Image;
import main.Element.View;

public class PlatformView extends View {
    protected PlatformView(){}

    public PlatformView(String imageLink, int positionX, int positionY, double width, double height) {
        setImage(new Image(imageLink, width, height, true, true));
        setX(positionX);
        setY(positionY);
    }
}