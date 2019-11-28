package main.Element.End;

import javafx.scene.image.Image;
import main.Element.View;

public class EndView extends View {
    private Image emptyEnd, occupiedEnd;
    private String filePathToEmptyEnd = "file:src/img/End/End.png";
    private String filePathToOccupiedEnd = "file:src/img/End/FrogEnd.png";

    private EndController controller;
    private EndModel model;

    public EndView(int positionX, int positionY, double width, double height) {
        emptyEnd = new Image(filePathToEmptyEnd, width, height, true, true);
        occupiedEnd = new Image(filePathToOccupiedEnd, width, height, true, true);

        setImage(emptyEnd);

        createModel();
        createController();

        setX(positionX);
        setY(positionY);
    }

    public void createModel(){
        this.model = new EndModel();
    }

    public void createController(){
        this.controller = new EndController(this.model);
    }

    public boolean checkStatus(){
        return (this.model.getStatus() == EndModel.Status.EMPTY);
    }

    public void occupyEnd(){
        setImage(occupiedEnd);
        this.model.setStatus(EndModel.Status.OCCUPIED);
    }

    @Override
    public void act(long timer){}
}
