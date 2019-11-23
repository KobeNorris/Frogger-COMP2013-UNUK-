package main.Element.Obstacle;

import javafx.scene.image.Image;
import main.Element.Viewer;

public class ObstacleViewer extends Viewer {
    protected ObstacleViewer(){}

    public ObstacleViewer(String imageLink, int positionX, int positionY, double width, double height) {
        setImage(new Image(imageLink, width, height, true, true));
        setX(positionX);
        setY(positionY);
    }
}