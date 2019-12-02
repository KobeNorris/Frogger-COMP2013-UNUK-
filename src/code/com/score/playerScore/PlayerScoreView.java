package code.com.score.playerScore;

import javafx.scene.image.Image;
import code.com.View;

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
