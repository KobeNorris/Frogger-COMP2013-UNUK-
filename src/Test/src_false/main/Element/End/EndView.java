package main.Element.End;

import javafx.scene.image.Image;
import main.Element.View;

public class EndView extends View {
    private Image emptyEnd, occupiedEnd;
    private String filePathToEmptyEnd = "file:src/img/End/End.png";
    private String filePathToOccupiedEnd = "file:src/img/End/FrogEnd.png";

    public EndView(int positionX, int positionY, double width, double height) {
        emptyEnd = new Image(filePathToEmptyEnd, width, height, true, true);
        occupiedEnd = new Image(filePathToOccupiedEnd, width, height, true, true);
        setImage(emptyEnd);
//        setImage(occupiedEnd);
        setX(positionX);
        setY(positionY);
    }

    public void occupyEnd(){
        setImage(occupiedEnd);
    }
}
