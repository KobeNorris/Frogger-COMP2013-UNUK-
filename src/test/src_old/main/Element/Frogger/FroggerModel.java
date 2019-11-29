package main.Element.Frogger;

//import main.Element.End.EndView;
import main.Element.Model;
import main.Element.Obstacle.ObstacleView;
//import main.Element.Platform.PlatformView;
//import main.Element.Platform.Turtle.WetTurtle.WetTurtleView;

public class FroggerModel extends Model {
    private Status status;

    int points = 0;
    boolean noMove = false;
    boolean stop = false;
    double presentHighestPosition;
//    double upBound = 114.4, leftBound = 22, bottomBound = 760.0, rightBound = 538.0;
    double upBound = 114.4, leftBound = 0, bottomBound = 760.0, rightBound = 560;

    public FroggerModel(){
        this.status = Status.ALIVE;
        this.presentHighestPosition = 800;
    }

    public void changePoints(int point){
        this.points += point;
        if(this.points < 0)
            this.points = 0;
    }

    public void setStatus(Status status){
        this.status = status;
    }

    public Status getStatus(){return this.status; }


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