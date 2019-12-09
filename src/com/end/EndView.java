package com.end;

import javafx.scene.image.Image;
import com.View;

/**
 * This End class is refactored from original End class, has 4 status in total.
 */
public class EndView extends View {
    private Image emptyEnd, frogOccupiedEnd, crocOccupiedEnd, bugOccupiedEnd;

    private EndController controller;
    private EndModel model;

    /**
     * This constructor initialise the position and size of End
     *
     * @param positionX End's X position
     * @param positionY End's Y position
     * @param width  End's width
     * @param height  End's height
     */
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

    /**
     * Checks whether this End is Empty
     *
     * @return Whether this End is Empty
     */
    public boolean checkStatusEMPTY(){return this.model.getStatus() == EndModel.Status.EMPTY;}

    /**
     * Checks whether this End is Occupied by Bug
     *
     * @return Whether this End is Occupied by Bug
     */
    public boolean checkStatusBUGOCCUPIED(){return this.model.getStatus() == EndModel.Status.BUGOCCUPIED;}

    /**
     * Checks whether this End is Occupied by Crocodile
     *
     * @return Whether this End is Occupied by Crocodile
     */
    public boolean checkStatusCROCOCCUPIED(){return this.model.getStatus() == EndModel.Status.CROCOCCUPIED;}

    /**
     * Checks whether this End is Occupied by frogger
     *
     * @return Whether this End is Occupied by frogger
     */
    public boolean checkStatusFROGOCCUPIED(){return this.model.getStatus() == EndModel.Status.FROGOCCUPIED;}

    /**
     * This method update the present status of the End, the
     * status include:
     *      1. Empty;
     *      2. Occupied by frogger;
     *      3. Occupied by bug;
     *      4. Occupied by crocodile.
     *
     * @param type The type of End that it needs to be updated to be
     */
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
