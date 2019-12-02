package code.com.frogger;

import code.com.Model;

public class FroggerModel extends Model {
    private Status status;
    private int points = 0;

    int reachedEnd = 0, life = 3;
    boolean noMove = false;
    boolean changeScore = false, changeLife = false;
    boolean stop = false;
    double presentHighestPosition;
    double upBound = 114.4, leftBound = 0, bottomBound = 760.0, rightBound = 560;

    public FroggerModel(){
        this.status = Status.ALIVE;
        this.presentHighestPosition = 800;
    }

    public void setStatus(Status status){
        this.status = status;
    }
    public Status getStatus(){return this.status; }

    public int getPoints(){
        return points;
    }
    public void setPoints(int targetPoints){
        points = targetPoints;
    }
    public void changePoints(int point){
        this.points += point;
        if(this.points < 0)
            this.points = 0;
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