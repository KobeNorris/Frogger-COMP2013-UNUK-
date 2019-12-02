package code.com.gameMode;

import code.Main;
import code.com.View;
import javafx.scene.image.Image;

public class GameModeView extends View {
    private String filePath = "file:src/resource/img/com/";

    public GameModeView(double positionX, double positionY){
        switch (Main.getPresentMode()){
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
