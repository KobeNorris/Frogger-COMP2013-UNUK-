package main.Element.Obstacle;

import javafx.scene.image.Image;
import main.Element.View;

public class ObstacleView extends View {
    protected ObstacleView(){}

    @Override
    public void act(long timer){};

    public ObstacleView(String imageLink, int positionX, int positionY, double width, double height) {
        setImage(new Image(imageLink, width, height, true, true));
        setX(positionX);
        setY(positionY);
    }
}