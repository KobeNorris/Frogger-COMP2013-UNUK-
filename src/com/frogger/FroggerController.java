package com.frogger;

import com.obstacle.ObstacleView;
import com.platform.PlatformView;
import controller.gameController.InfiniteGameController;
//import main.GameApp;
import com.Controller;
import com.end.EndView;
import gameApp.Main;

public class FroggerController implements Controller{
    private FroggerModel model;

    public FroggerController(FroggerModel model){
        this.model = model;
    }

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

    public void resetToStart(){
        this.model.setStatus(FroggerModel.Status.ALIVE);
        this.model.noMove = false;
        model.life = 3;
        model.reachedEnd = 0;
        model.stop = false;
    }

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

    public void checkPosition(FroggerView view){
        double positionY = view.getY();
        if(model.presentHighestPosition > positionY){
            this.model.changePoints(10);
            model.changeScore = true;
            model.presentHighestPosition = positionY;
        }
    }

    public void bonusPoints(){
        this.model.changePoints(50);
        this.model.changeScore = true;
    }

    public void blockMove(){this.model.noMove = true;}

    public boolean checkStatus(FroggerView view){
        checkBoundary(view);
        if(this.model.time <= 0)
            this.model.setStatus(FroggerModel.Status.ROADDEATH);
        if (view.getIntersectingObjects(ObstacleView.class).size() >= 1) {
            this.model.setStatus(FroggerModel.Status.ROADDEATH);
            blockMove();
            return true;
        }else if(view.getY() < 413){
            if (view.getIntersectingObjects(PlatformView.class).size() == 0){
                this.model.setStatus(FroggerModel.Status.WATERDEATH);
                blockMove();
                return true;
            }else{
                PlatformView inspectObject = view.getIntersectingObjects(PlatformView.class).get(0);
                view.move(inspectObject.getSpeed() * Main.diffficulty , 0);
                if(view.getIntersectingObjects(PlatformView.class).get(0).isSunk()){
                    this.model.setStatus(FroggerModel.Status.WATERDEATH);
                    blockMove();
                    return true;
                }else if(view.getIntersectingObjects(EndView.class).size() >= 1){
                    EndView tempEndView = view.getIntersectingObjects(EndView.class).get(0);
                    if(tempEndView.checkStatusFROGOCCUPIED() || tempEndView.checkStatusCROCOCCUPIED()){
                        this.model.setStatus(FroggerModel.Status.WATERDEATH);
                        blockMove();
                        return true;
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
        return false;
    }
}
