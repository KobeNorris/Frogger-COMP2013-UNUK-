package com.frogger;

import com.Model;

/**
 * This class is the Model for frogger, stores frogger's status, player's present score, remaining time
 * and life number.+
 */
public class FroggerModel implements Model {
    private Status status;
    private int points = 0;
    private String filePath = "file:resources/img/FroggerAction/";

    String gameMode;
    int reachedEnd = 0, life = 3, time = 90;
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

    /**
     * Add the input points to player's current points
     *
     * @param point Target change points
     */
    public void changePoints(int point){
        this.points += point;
        if(this.points < 0)
            this.points = 0;
    }

    /**
     * Check the score status and if it is active, set it to  false
     *
     * @return Previous score status
     */
    public boolean checkScore(){
        if(changeScore){
            changeScore = false;
            return true;
        }else
            return false;
    }

    /**
     * Check the life status and if it is active, set it to  false
     *
     * @return Previous life status
     */
    public boolean checkLife(){
        if(changeLife){
            changeLife = false;
            return true;
        }else
            return false;
    }

    public String getFilePath(){return this.filePath;}

    /**
     * Possible status of frogger, include:
     *      1. Alive;
     *      2. Road death;
     *      3. Water death.
     */
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