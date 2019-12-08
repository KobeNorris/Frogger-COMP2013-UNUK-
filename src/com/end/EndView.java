package com.end;

import javafx.scene.image.Image;
import com.View;

public class EndView extends View {
    private Image emptyEnd, frogOccupiedEnd, crocOccupiedEnd, bugOccupiedEnd;

    private EndController controller;
    private EndModel model;

    public EndView(int positionX, int positionY, double width, double height) {
        createModel();
        createController();

        emptyEnd = new Image(this.model.getFilePathToEmptyEnd(), width, height, true, true);
        frogOccupiedEnd = new Image(this.model.getFilePathToFrogOccupiedEnd(), width, height, true, true);
        crocOccupiedEnd = new Image(this.model.getFilePathToCrocOccupiedEnd(), width, height, true, true);
        bugOccupiedEnd = new Image(this.model.getFilePathToBugOccupiedEnd(), width, height, true, true);
        setImage(emptyEnd);

        setX(positionX);
        setY(positionY);
    }

    public void createModel(){
        this.model = new EndModel();
    }

    public void createController(){
        this.controller = new EndController(this.model);
    }

    public boolean checkStatusEMPTY(){return this.model.getStatus() == EndModel.Status.EMPTY;}
    public boolean checkStatusBUGOCCUPIED(){return this.model.getStatus() == EndModel.Status.BUGOCCUPIED;}
    public boolean checkStatusCROCOCCUPIED(){return this.model.getStatus() == EndModel.Status.CROCOCCUPIED;}
    public boolean checkStatusFROGOCCUPIED(){return this.model.getStatus() == EndModel.Status.FROGOCCUPIED;}

    public void occupyEnd(String type){
        switch(type){
            case "frog":
                setImage(frogOccupiedEnd);
                this.model.frogOccupied();
                break;
            case "bug":
                setImage(bugOccupiedEnd);
                this.model.bugOccupied();
                break;
            case "croc":
                setImage(crocOccupiedEnd);
                this.model.crocOccupied();
                break;
            case "empty":
                setImage(emptyEnd);
                this.model.setToEmpty();
                break;
            default:
                System.out.println("Can not resolve type: " + type + " in EndView.java");
        }
    }

    @Override
    public void act(long timer){}
}
