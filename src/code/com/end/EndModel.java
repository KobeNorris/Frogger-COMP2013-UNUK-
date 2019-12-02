package code.com.end;

import code.com.Model;

public class EndModel extends Model {
    private Status status;
    private String filePathToEmptyEnd = "file:src/resource/img/End/EmptyEnd.png";
    private String filePathToFrogOccupiedEnd = "file:src/resource/img/End/FrogEnd.png";
    private String filePathToCrocOccupiedEnd = "file:src/resource/img/End/CrocEnd.png";
    private String filePathToBugOccupiedEnd = "file:src/resource/img/End/BugEnd.png";

    public EndModel(){
        this.status = Status.EMPTY;
    }

    public String getFilePathToEmptyEnd(){return this.filePathToEmptyEnd;}
    public String getFilePathToFrogOccupiedEnd(){return this.filePathToFrogOccupiedEnd;}
    public String getFilePathToCrocOccupiedEnd(){return this.filePathToCrocOccupiedEnd;}
    public String getFilePathToBugOccupiedEnd(){return this.filePathToBugOccupiedEnd;}

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
