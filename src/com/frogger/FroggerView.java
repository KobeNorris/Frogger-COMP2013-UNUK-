package com.frogger;

import controller.gameController.HardGameController;
import controller.gameController.InfiniteGameController;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import com.View;

public class FroggerView extends View {
    private Image imgUp, imgLeft, imgRight, imgDown, imgUpJump, imgLeftJump, imgRightJump, imgDownJump;
    private Image waterDeath1, waterDeath2, waterDeath3, waterDeath4, roadDeath1, roadDeath2, roadDeath3;
    private int imgSize = 40, frameTimeInverval = 11;
    private double originPositionX, originPositionY;
    private double movementX = 10.666666 * 2, movementY = 13.45 * 2;
    private boolean moveComplete = false, jumpComplete = false;
    private int deathFrame = 0;

    private static FroggerView view = null;
    private FroggerController controller;
    private FroggerModel model;

    public KeyCode previousKey;

    public static FroggerView getFroggerView(){
        if(FroggerView.view == null)
            FroggerView.view = new FroggerView();
        return view;
    }

    private FroggerView(){
        createModel();
        createController();
        model.changeScore = true;
        model.changeLife = true;
        originPositionX = 280.0;
        originPositionY = 730.0 + movementY;
        loadImage();
        setBackToStart();

        setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event){
                keyBoardPress(event.getCode());
            }
        });

        setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                keyBoardRelease(event.getCode());
            }
        });
    }

    public void createModel(){
        this.model = new FroggerModel();
    }

    public void createController(){
        this.controller = new FroggerController(this.model);
    }

    public void setBackToStart(){
        setX(originPositionX);
        setY(originPositionY);
        previousKey = null;
        setTime(90);
        moveComplete = false;
        jumpComplete = false;
        deathFrame = 0;
        setImage(imgUp);
    }

    public void changeEnd(){
        if(this.model.gameMode.equals("Hard")){
            HardGameController.changeEnd();
        }else if(this.model.gameMode.equals("Infinite")){
            InfiniteGameController.changeEnd();
        }
    }

    public void loadImage(){
        imgUp = new Image(this.model.getFilePath() + "froggerUp.png", imgSize, imgSize, true, true);
        imgLeft = new Image(this.model.getFilePath() + "froggerLeft.png", imgSize, imgSize, true, true);
        imgDown = new Image(this.model.getFilePath() + "froggerDown.png", imgSize, imgSize, true, true);
        imgRight = new Image(this.model.getFilePath() + "froggerRight.png", imgSize, imgSize, true, true);
        imgUpJump = new Image(this.model.getFilePath() + "froggerUpJump.png", imgSize, imgSize, true, true);
        imgLeftJump = new Image(this.model.getFilePath() + "froggerLeftJump.png", imgSize, imgSize, true, true);
        imgDownJump = new Image(this.model.getFilePath() + "froggerDownJump.png", imgSize, imgSize, true, true);
        imgRightJump = new Image(this.model.getFilePath() + "froggerRightJump.png", imgSize, imgSize, true, true);

        waterDeath1 = new Image(this.model.getFilePath() + "waterDeath1.png", imgSize, imgSize, true, true);
        waterDeath2 = new Image(this.model.getFilePath() + "waterDeath2.png", imgSize, imgSize, true, true);
        waterDeath3 = new Image(this.model.getFilePath() + "waterDeath3.png", imgSize, imgSize, true, true);
        waterDeath4 = new Image(this.model.getFilePath() + "waterDeath4.png", imgSize, imgSize, true, true);
        roadDeath1 = new Image(this.model.getFilePath() + "carDeath1.png", imgSize, imgSize, true, true);
        roadDeath2 = new Image(this.model.getFilePath() + "carDeath2.png", imgSize, imgSize, true, true);
        roadDeath3 = new Image(this.model.getFilePath() + "carDeath3.png", imgSize, imgSize, true, true);
    }

    public void keyBoardPress(KeyCode pressedKey){
        if(!this.model.noMove && (previousKey == pressedKey || previousKey == null)){
            if(moveComplete){
                switch (pressedKey){
                    case W:
                        move(0, -movementY);
                        setImage(imgUp);
                        break;
                    case A:
                        move(-movementX, 0);
                        setImage(imgLeft);
                        break;
                    case S:
                        move(0, movementY);
                        setImage(imgDown);
                        break;
                    case D:
                        move(movementX, 0);
                        setImage(imgRight);
                        break;

                    default:
                }
                moveComplete = false;
                jumpComplete = false;
            }else{
                previousKey = pressedKey;
                switch (pressedKey){
                    case W:
                        move(0, -movementY);
                        setImage(imgUpJump);
                        controller.checkPosition(this);
                        break;
                    case A:
                        move(-movementX, 0);
                        setImage(imgLeftJump);
                        break;
                    case S:
                        move(0, movementY);
                        setImage(imgDownJump);
                        break;
                    case D:
                        move(movementX, 0);
                        setImage(imgRightJump);
                        break;
                    default:
                }
                moveComplete = true;
                jumpComplete = true;
            }
        }
    }

    public void keyBoardRelease(KeyCode releasedKey){
        if(!this.model.noMove && previousKey == releasedKey){
            previousKey = null;
            if(jumpComplete){
                switch (releasedKey) {
                    case W:
                        move(0, -movementY);
                        setImage(imgUp);
                        break;
                    case A:
                        move(-movementX, 0);
                        setImage(imgLeft);
                        break;
                    case S:
                        move(0, movementY);
                        setImage(imgDown);
                        break;
                    case D:
                        move(movementX, 0);
                        setImage(imgRight);
                        break;
                    default:
                }
            }else{
                switch (releasedKey) {
                    case W:
                        setImage(imgUp);
                        break;
                    case A:
                        setImage(imgLeft);
                        break;
                    case S:
                        setImage(imgDown);
                        break;
                    case D:
                        setImage(imgRight);
                        break;
                    default:
                }
            }
        }
        moveComplete = false;
    }

    public boolean waterDeath(long timer){
        if ((timer)% frameTimeInverval == 0)
            deathFrame++;
        switch(deathFrame) {
            case 1:
                setImage(waterDeath1);
                return false;
            case 2:
                setImage(waterDeath2);
                return false;
            case 3:
                setImage(waterDeath3);
                return false;
            case 4:
                setImage(waterDeath4);
                return false;
            case 5:
                return true;
            default:
                return false;
        }
    }

    public boolean roadDeath(long timer) {
        if ((timer) % frameTimeInverval == 0)
            deathFrame++;
        switch (deathFrame) {
            case 1:
                setImage(roadDeath1);
                return false;
            case 2:
                setImage(roadDeath2);
                return false;
            case 3:
                setImage(roadDeath3);
                return false;
            case 4:
                return true;
            default:
                return false;
        }
    }

    public void resetFroggerModelToStart(){this.controller.resetToStart();}

    public void resetPresentHighestPosition(){this.model.presentHighestPosition = 800;}

    public void setGameMode(String targetMode){this.model.gameMode = targetMode;}

    public int getPoints(){
        return this.model.getPoints();
    }

    public void resetPoints(){
        this.model.setPoints(0);
    }

    public int getLife(){
        return this.model.life;
    }

    public int getRemainingTime() {return this.model.time;}

    public void deductTime() {
        if(this.model.time > 0)
            this.model.time--;
    }

    public void setTime(int targetTime){this.model.time = targetTime;}

    public boolean getStop(){
        return this.model.stop;
    }

    public void blockMove(){this.model.noMove = true;}

    public void releaseMove(){this.model.noMove = false;}

    public boolean checkAttribute(String attribute){
        switch(attribute){
            case "Score":
                return this.model.checkScore();
            case "Life":
                return this.model.checkLife();
            default:
                return false;
        }
    }

    @Override
    public void act(long timer){
        FroggerModel.Status status = this.model.getStatus();
        if( status != FroggerModel.Status.ALIVE){
            if( status == FroggerModel.Status.ROADDEATH){
                if(roadDeath(timer)){
                    this.controller.revive();
                    previousKey = null;
                    model.changeScore = true;
                    setBackToStart();
                }
            }else if(status == FroggerModel.Status.WATERDEATH){
                if(waterDeath(timer)){
                    this.controller.revive();
                    previousKey = null;
                    model.changeScore = true;
                    setBackToStart();
                }
            }
        }else{
            this.controller.checkStatus(this);
        }
    }
}
