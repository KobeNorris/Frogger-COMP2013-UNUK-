package com.frogger;

import com.Model;

/**
 * <h1>FroggerModel</h1>
 *
 * <p>This class is the {@link Model} for frogger, stores frogger's status, player's present score, remaining time
 * and life number. FroggerController could manipulate {@link FroggerModel} directly.
 *
 *     <br>Refactor:<br>
 *          1. Add internal enum class to represent frogger status;<br>
 *          2. Stores player's present score, life and block status.<br>
 *
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.4
 * @since 1.0
 * @see Model
 */
public class FroggerModel implements Model {
    /**
     * The present status of frogger
     */
    private Status status;
    private int points = 0;
    private String filePath = "file:src/main/resources/img/FroggerAction/";

    /**
     * Present game mode
     */
    String gameMode;
    int reachedEnd = 0, life = 3, roundTime = 60, remainingTime;
    boolean enableChangeEnd, noMove = false;
    /**
     * Update instructions
     */
    boolean changeScore = false, changeLife = false;
    boolean stop = false;
    /**
     * The present highest level player has reached
     */
    double presentHighestPosition;
    /**
     * The boundary of the game stage
     */
    double upBound = 114.4, leftBound = 0, bottomBound = 760.0, rightBound = 560;

    public FroggerModel(){
        this.status = Status.ALIVE;
        this.presentHighestPosition = 800;
    }

    /**
     * Set frogger status to target status
     *
     * @param targetStatus Target status
     */
    public void setStatus(Status targetStatus){
        this.status = targetStatus;
    }

    /**
     * et player's present status
     *
     * @return Player's present status
     */
    public Status getStatus(){return this.status; }

    /**
     * Get player's present points
     *
     * @return Player's present points
     */
    public int getPoints(){
        return points;
    }

    /**
     * Set player's present points to target points
     *
     * @param targetPoints Target points
     */
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