package main.Element.Obstacle.Truck.ShortTruck;

import javafx.scene.image.Image;
import main.Element.Obstacle.ObstacleView;

public class ShortTruckView extends ObstacleView {
    public ShortTruckView(String imageLink, int positionX, int positionY, double width, double height) {
        setImage(new Image(imageLink, width, height, true, true));
        setX(positionX);
        setY(positionY);
    }
}
