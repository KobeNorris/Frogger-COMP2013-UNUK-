package com.end;

import com.Model;

/**
 * This is the model class for view which stores End's present status
 */
public class EndModel implements Model {
    private Status status;
    private String filePath = "file:resources/img/End/";

    public EndModel(){
        this.status = Status.EMPTY;
    }

    public String getFilePathToEmptyEnd(){return this.filePath + "EmptyEnd.png";}
    public String getFilePathToFrogOccupiedEnd(){return this.filePath + "FrogEnd.png";}
    public String getFilePathToCrocOccupiedEnd(){return this.filePath + "CrocEnd.png";}
    public String getFilePathToBugOccupiedEnd(){return this.filePath + "BugEnd.png";}

    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status){
        this.status = status;
    }

    /**
     * Set End status to frogger occupied
     */
    public void frogOccupied(){this.status = Status.FROGOCCUPIED;}

    /**
     * Set End status to crocodile occupied
     */
    public void crocOccupied(){this.status = Status.CROCOCCUPIED;}

    /**
     * Set End status to bug occupied
     */
    public void bugOccupied(){this.status = Status.BUGOCCUPIED;}

    /**
     * Set End status to empty
     */
    public void setToEmpty(){this.status = Status.EMPTY;}

    /**
     * The status of Ends
     */
    enum Status{
        EMPTY(0),
        FROGOCCUPIED(1),
        CROCOCCUPIED(2),
        BUGOCCUPIED(3);

        private int value;

        Status(int value){
            this.value = value;
        }

        int toInt(){
            return this.value;
        }
    }
}
