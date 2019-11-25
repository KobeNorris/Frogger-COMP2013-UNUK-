package main.Element.Frogger;

public class FroggerModel {
    Status status;

    int points = 0;
    int end = 0;
    int imgSize = 40;
    int deathFrame = 0;
    boolean noMove = false;
    boolean stop = false;
    boolean changeScore = false;
    double presentHighestPosition;
    double upBound = 114.4, leftBound = 22, bottomBound = 760.0, rightBound = 538.0;
    String filePath = "file:src/img/FroggerAction/";

    public FroggerModel(){
        this.status = Status.ALIVE;
        this.presentHighestPosition = 800;
    }

    enum Status{
        ALIVE(0),
        ROADDEATH(1),
        WATERDEATH(2);

        private int value;

        Status(int value){
            this.value = value;
        }

        int toInt(){
            return this.value;
        }
    }

}