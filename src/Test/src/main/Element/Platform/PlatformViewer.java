package main.Element.Platform;

import javafx.application.Platform;
import javafx.scene.image.Image;
import main.Element.Viewer;

public class PlatformViewer extends Viewer {
    protected PlatformViewer(){}

    public PlatformViewer(String imageLink, int positionX, int positionY, double width, double height) {
        setImage(new Image(imageLink, width, height, true, true));
        setX(positionX);
        setY(positionY);
    }
}