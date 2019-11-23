package main.Element.Obstacle.Truck.LongTruck;

import javafx.scene.image.Image;
import main.Element.Obstacle.ObstacleViewer;

public class LongTruckViewer extends ObstacleViewer {
    public LongTruckViewer(String imageLink, int positionX, int positionY, double width, double height) {
        setImage(new Image(imageLink, width, height, true, true));
        setX(positionX);
        setY(positionY);
    }
}
