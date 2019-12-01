package main.Element.Score.PlayerScore;

import javafx.scene.image.Image;
import main.Element.View;

public class PlayerScoreView extends View {
    private String filePath = "file:src/resource/img/Digit/";

    public PlayerScoreView(double positionX, double positionY, double size){
        setImage(new Image(filePath + "playerScoreTitle.png", size, size, true, true));

        setX(positionX);
        setY(positionY);
    }

    @Override
    public void act(long timer){}
}
