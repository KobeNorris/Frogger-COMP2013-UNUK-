package main.Element.End;

import main.Element.Model;

public class EndModel extends Model {
    private Status status;

    public EndModel(){
        this.status = Status.EMPTY;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status){
        this.status = status;
    }

    enum Status{
        EMPTY(0),
        OCCUPIED(1);

        private int value;

        Status(int value){
            this.value = value;
        }

        int toInt(){
            return this.value;
        }
    }
}
