package main.Element.Obstacle.Truck.ShortTruck;

import javafx.scene.image.Image;
import main.Element.Obstacle.ObstacleViewer;

public class ShortTruckViewer extends ObstacleViewer {
    public ShortTruckViewer(String imageLink, int positionX, int positionY, double width, double height) {
        setImage(new Image(imageLink, width, height, true, true));
        setX(positionX);
        setY(positionY);
    }
}
