package main.java.com.gameMode;

import main.java.com.View;
import javafx.scene.image.Image;

public class GameModeView extends View {
    private String filePath = "file:src/main/resources/img/com/";

    public GameModeView(String gameMode, double positionX, double positionY){
        switch (gameMode){
            case "Easy":
                setImage(new Image(filePath + "easyMode.png", 140, 140, true, true));
                break;
            case "Hard":
                setImage(new Image(filePath + "hardMode.png", 140, 140, true, true));
                break;
            case "Infinite":
                setImage(new Image(filePath + "infiniteMode.png", 140, 140, true, true));
                break;
            default:
        }

        setX(positionX);
        setY(positionY);
    }

    @Override
    public void act(long timer){}
}
