package main.Element.Obstacle;

import javafx.scene.image.Image;
import main.Element.View;

public class ObstacleView extends View {
    protected ObstacleView(){}

    public ObstacleView(String imageLink, int positionX, int positionY, double width, double height) {
        setImage(new Image(imageLink, width, height, true, true));
        setX(positionX);
        setY(positionY);
    }
}