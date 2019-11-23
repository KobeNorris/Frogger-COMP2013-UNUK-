package main.Element.Platform.Turtle.DryTurtle;

import javafx.scene.image.Image;
import main.Element.Platform.PlatformViewer;

public class DryTurtleViewer extends PlatformViewer {
    public DryTurtleViewer(String imageLink, int positionX, int positionY, double width, double height) {
        setImage(new Image(imageLink, width, height, true, true));
        setX(positionX);
        setY(positionY);
    }
}
