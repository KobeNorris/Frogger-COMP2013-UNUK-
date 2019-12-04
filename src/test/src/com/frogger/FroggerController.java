package com.frogger;

import com.Controller;

public class FroggerController extends Controller{
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
}
