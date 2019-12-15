package com.end;

import controller.gameController.HardGameController;
import controller.gameController.InfiniteGameController;
import javafx.scene.image.Image;
import com.View;

/**
 * <h1>EndView</h1>
 *
 * <p>This End class is refactored from original End class, has 4 status in total.
 * It is extended from {@link View} class:
 *
 *     <br>Refactor:<br>
 *          1. This class is purely used for demonstration;<br>
 *          2. Moved the methods related to End status to {@link EndModel} and {@link EndController};<br>
 *
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.3
 * @since 1.0
 * @see View
 * @see EndModel
 * @see EndController
 */
public class EndView extends View {
    /**
     * The image of ends in different status
     */
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

    /**
     * EndView will not change itself during the execution, it could only be manipulated by
     * gameControllers {@link HardGameController#changeEnd()} and {@link InfiniteGameController#changeEnd()}
     *
     * @param timer Value of present timer counter
     */
    @Override
    public void act(long timer){}
}
