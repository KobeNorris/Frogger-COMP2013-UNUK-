package com.frogger;

import controller.gameController.GameController;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import com.View;

/**
 * <h1>FroggerView</h1>
 *
 * <p>This is the {@link View} class for frogger, which displays the moving frames, death animation and
 * defines the key board listener. It is refactored from original Animal class.
 *
 *     <br>Refactor:<br>
 *          1. Moved the boundary checking into {@link FroggerController};<br>
 *          2. Debugged the original keyboard listener and maintained the pressing move;<br>
 *          3. The present status of the frogger is stored in {@link FroggerModel}.<br>
 *
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.4
 * @since 1.0
 * @see View
 * @see FroggerController
 * @see FroggerModel
 */
public class FroggerView extends View {
    /**
     * The image of frogger actions
     */
    private Image imgUp, imgLeft, imgRight, imgDown, imgUpJump, imgLeftJump, imgRightJump, imgDownJump;
    /**
     * The image of frogger death frames
     */
    private Image waterDeath1, waterDeath2, waterDeath3, waterDeath4, roadDeath1, roadDeath2, roadDeath3;
    /**
     * Some constant parameters
     */
    private int imgSize = 40, frameTimeInverval = 11;
    private double originPositionX, originPositionY;
    private double movementX = 10.666666 * 2, movementY = 13.45 * 2;
    private boolean moveComplete = false, jumpComplete = false;
    private int deathFrame = 0;

    /**
     * The instance of FroggerView which applied the SINGLETON
     */
    private static FroggerView view = null;
    private FroggerController controller;
    private FroggerModel model;

    public KeyCode previousKey;

    /**
     * This method implements the SINGLETON design pattern
     *
     * @return The instance of frogger
     */
    public static FroggerView getFroggerView(){
        if(FroggerView.view == null)
            FroggerView.view = new FroggerView();
        return view;
    }

    /**
     * Initialise frogger's position, status and image, add keyboard listeners
     */
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

    /**
     * Set frogger's position and status back to the start of the game
     */
    public void setBackToStart(){
        setX(originPositionX);
        setY(originPositionY);
        previousKey = null;
        setTime(this.model.roundTime);
        moveComplete = false;
        jumpComplete = false;
        deathFrame = 0;
        setImage(imgUp);
    }

    /**
     * Call the game end functions
     */
    public void changeEnd(){
//        if(this.model.gameMode.equals("Hard") || this.model.gameMode.equals("Infi"))
        if(this.model.enableChangeEnd)
            GameController.changeEnd();
    }

    /**
     * Pre-load the image resources in order to improve efficiency
     */
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

    /**
     * Listen to the key board press event, listens to W, A, S and D keys
     *
     * @param pressedKey The key has been pressed
     */
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

    /**
     * Listen to the key board release event, listens to W, A, S and D keys
     *
     * @param releasedKey The key has been released
     */
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

    /**
     * Demonstrate the frames of water death
     *
     * @param timer The current value of time counter
     * @return Whether the demonstration is finished
     */
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

    /**
     * Demonstrate the frames of road death
     *
     * @param timer The current value of time counter
     * @return Whether the demonstration is finished
     */
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

    public void setChangeEndMode(Boolean changeEnd){
        this.model.enableChangeEnd = changeEnd;
        changeEnd();
    }

    public int getPoints(){
        return this.model.getPoints();
    }

    public void resetPoints(){
        this.model.setPoints(0);
    }

    public int getLife(){
        return this.model.life;
    }

    public int getRemainingTime() {return this.model.remainingTime;}

    public void deductTime() {
        if(this.model.remainingTime > 0)
            this.model.remainingTime--;
    }

    public void setTime(int targetTime){this.model.remainingTime = targetTime;}

    public boolean getStop(){
        return this.model.stop;
    }

    /**
     * Block the keyboard block and forbid player to manipulate the frogger
     */
    public void blockMove(){this.model.noMove = true;}

    /**
     * Release the keyboard block and enable player to manipulate the frogger
     */
    public void releaseMove(){this.model.noMove = false;}

    /**
     * Check frogger's selected attributes
     *
     * @param attribute Target attribute
     * @return The value of the attribute
     */
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

    /**
     * This method with automatically check and update the status of frogger, and if the frogger is died
     * already, iy will check whether frogger death animation is completed or not. If so, the frogger with
     * be set back to start position and the remaining time, frogger image will be set back to start status
     * simultaneously.
     *
     * @param timer Value of present timer counter
     */
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
