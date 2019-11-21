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
    double presentHighestPosition = 800;

    public FroggerModel(){
        this.status = Status.ALIVE;
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