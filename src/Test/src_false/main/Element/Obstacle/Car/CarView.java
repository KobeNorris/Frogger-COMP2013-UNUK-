package main.Element.Obstacle.Car;

import javafx.scene.image.Image;
import main.Element.Obstacle.ObstacleView;

public class CarView extends ObstacleView {
    public CarView(String imageLink, int positionX, int positionY, double width, double height) {
        setImage(new Image(imageLink, width, height, true, true));
        setX(positionX);
        setY(positionY);
    }
}
