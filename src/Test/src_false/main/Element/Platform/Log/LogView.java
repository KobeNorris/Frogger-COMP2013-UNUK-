package main.Element.Platform.Log;

import javafx.scene.image.Image;
import main.Element.Platform.PlatformView;

public class LogView extends PlatformView {
    public LogView(String imageLink, int positionX, int positionY, double width, double height) {
        setImage(new Image(imageLink, width, height, true, true));
        setX(positionX);
        setY(positionY);
    }
}
