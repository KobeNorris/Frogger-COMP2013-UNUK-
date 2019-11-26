package main.Element.Obstacle.Truck.LongTruck;

import javafx.scene.image.Image;
import main.Element.Obstacle.ObstacleView;

public class LongTruckView extends ObstacleView {
    public LongTruckView(String imageLink, int positionX, int positionY, double width, double height) {
        setImage(new Image(imageLink, width, height, true, true));
        setX(positionX);
        setY(positionY);
    }
}
