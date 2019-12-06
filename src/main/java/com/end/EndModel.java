package main.java.com.end;

import main.java.com.Model;

public class EndModel implements Model {
    private Status status;
    private String filePath = "file:src/main/resources/img/End/";

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

    public void frogOccupied(){this.status = Status.FROGOCCUPIED;}
    public void crocOccupied(){this.status = Status.CROCOCCUPIED;}
    public void bugOccupied(){this.status = Status.BUGOCCUPIED;}
    public void setToEmpty(){this.status = Status.EMPTY;}

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
