package com.frogger;

import com.obstacle.ObstacleView;
import com.platform.PlatformView;
import controller.gameController.InfiniteGameController;
//import main.GameApp;
import com.Controller;
import com.end.EndView;
import gameApp.Main;

/**
 * <h1>FroggerController</h1>
 *
 * <p>FroggerController is constructed to check and reset FroggerView's position and status.
 * It is extends from {@link Controller} and it also enhance the connection between
 * {@link FroggerView} and {@link FroggerModel}.
 *
 * <br>
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.4
 * @since 1.0
 * @see Controller
 * @see FroggerView
 * @see FroggerModel
 */
public class FroggerController implements Controller{
    public FroggerModel model;

    public FroggerController(FroggerModel model){
        this.model = model;
    }

    /**
     * This method resets the frogger back to start place after it is died, and
     * check whether the game is already over.
     */
    public void revive(){
        this.model.setStatus(FroggerModel.Status.ALIVE);
        this.model.noMove = false;
        model.changeLife = true;
        this.model.changePoints(-50);
        if(--this.model.life == 0){
            this.model.noMove = true;
            this.model.stop = true;
        }
    }

    /**
     * This method reset the Ends status and player's life back to start after the game is over,
     * because FroggerView is an independent object applying SINGLETON design pattern.
     */
    public void resetToStart(){
        this.model.setStatus(FroggerModel.Status.ALIVE);
        this.model.noMove = false;
        model.life = 3;
        model.reachedEnd = 0;
        model.stop = false;
    }

    /**
     * This method will check current position of frogger and ensure it will not
     * cross the boundary of the game stage
     *
     * @param view Present FroggerView
     */
    public void checkBoundary(FroggerView view){
        double positionX = view.getX();
        double positionY = view.getY();

        if(positionX > model.rightBound){
            view.setX(model.rightBound);
        }else if(positionX < model.leftBound){
            view.setX(model.leftBound);
        }

        if(positionY < model.upBound){
            view.setY(model.upBound);
        }else if(positionY > model.bottomBound){
            view.setY(model.bottomBound);
        }
    }

    /**
     * This method will check current height of frogger to ensure that player will
     * get 10 points after each time he reaches present highest position.
     *
     * @param view Present FroggerView
     */
    public void checkPosition(FroggerView view){
        double positionY = view.getY();
        if(model.presentHighestPosition > positionY){
            this.model.changePoints(10);
            model.changeScore = true;
            model.presentHighestPosition = positionY;
        }
    }

    /**
     * The bonus point of 50 after player get a snack (bug in the end)
     */
    public void bonusPoints(){
        this.model.changePoints(50);
        this.model.changeScore = true;
    }

    /**
     * Forbid player to move.
     */
    public void blockMove(){this.model.noMove = true;}

    /**
     * This method will check frogger's present status, including:
     *      <br>1. Die in the road (Road death);
     *      <br>2. Die in the water (Water death);
     *      <br>3. Reaches the end;
     *      <br>4. Keeps alive.
     *
     *
     * @param view Present FroggerView
     */
    public void checkStatus(FroggerView view){
        checkBoundary(view);
        if(this.model.remainingTime <= 0)
            this.model.setStatus(FroggerModel.Status.ROADDEATH);
        if (view.getIntersectingObjects(ObstacleView.class).size() >= 1) {
            this.model.setStatus(FroggerModel.Status.ROADDEATH);
            blockMove();
        }else if(view.getY() < 413){
            if (view.getIntersectingObjects(PlatformView.class).size() == 0){
                this.model.setStatus(FroggerModel.Status.WATERDEATH);
                blockMove();
            }else{
                PlatformView inspectObject = view.getIntersectingObjects(PlatformView.class).get(0);
                view.move(inspectObject.getSpeed(), 0);
                if(view.getIntersectingObjects(PlatformView.class).get(0).isSunk()){
                    this.model.setStatus(FroggerModel.Status.WATERDEATH);
                    blockMove();
                }else if(view.getIntersectingObjects(EndView.class).size() >= 1){
                    EndView tempEndView = view.getIntersectingObjects(EndView.class).get(0);
                    if(tempEndView.checkStatusFROGOCCUPIED() || tempEndView.checkStatusCROCOCCUPIED()){
                        this.model.setStatus(FroggerModel.Status.WATERDEATH);
                        blockMove();
                    }else{
                        if(tempEndView.checkStatusBUGOCCUPIED())
                            bonusPoints();
                        tempEndView.occupyEnd("frog");
                        view.setBackToStart();
                        this.model.presentHighestPosition = 800;
                        if(++this.model.reachedEnd >= 5){
                            this.model.reachedEnd = 0;
                            if(this.model.gameMode.equals("Infinite")){
                                InfiniteGameController.resetGame();
                            }else{
                                blockMove();
                                this.model.stop = true;
                            }
                        }
                    }
                }
            }
        }
    }
}
