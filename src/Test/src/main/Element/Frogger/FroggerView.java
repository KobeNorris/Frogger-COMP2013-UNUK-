package main.Element.Frogger;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import main.Element.View;

public class FroggerView extends View {
    private Image imgUp, imgLeft, imgRight, imgDown, imgUpJump, imgLeftJump, imgRightJump, imgDownJump;
    private Image waterDeath1, waterDeath2, waterDeath3, waterDeath4, roadDeath1, roadDeath2, roadDeath3;
    private String filePath;
    private int imgSize = 40, timeInverval = 11;
    private double originPositionX, originPositionY;
    private double movementX = 10.666666 * 2, movementY = 13.45 * 2;
    private boolean moveComplete = true;
    private int deathFrame = 0;

    private FroggerController controller;
    private FroggerModel model;


    public FroggerView(String filePath){
        originPositionX = 280.0;
        originPositionY = 730.0 + movementY;
        loadImage();
        setBackToStart();
        createModel();
        createController();

        setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event){
//                if(!this.model.noMove){
//                    keyBoardPress(event.getCode());
//                }
                keyBoardPress(event.getCode());
            }
        });

        setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
//                if(!this.model.noMove){
//                    keyBoardRelease(event.getCode());
//                }
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
        deathFrame = 0;
        setImage(imgUp);
    }

    public void loadImage(){
        imgUp = new Image(filePath + "froggerUp.png", imgSize, imgSize, true, true);
        imgLeft = new Image(filePath + "froggerLeft.png", imgSize, imgSize, true, true);
        imgDown = new Image(filePath + "froggerDown.png", imgSize, imgSize, true, true);
        imgRight = new Image(filePath + "froggerRight.png", imgSize, imgSize, true, true);
        imgUpJump = new Image(filePath + "froggerUpJump.png", imgSize, imgSize, true, true);
        imgLeftJump = new Image(filePath + "froggerLeftJump.png", imgSize, imgSize, true, true);
        imgDownJump = new Image(filePath + "froggerDownJump.png", imgSize, imgSize, true, true);
        imgRightJump = new Image(filePath + "froggerRightJump.png", imgSize, imgSize, true, true);

        waterDeath1 = new Image(filePath + "waterDeath1.png", imgSize, imgSize, true, true);
        waterDeath2 = new Image(filePath + "waterDeath2.png", imgSize, imgSize, true, true);
        waterDeath3 = new Image(filePath + "waterDeath3.png", imgSize, imgSize, true, true);
        waterDeath4 = new Image(filePath + "waterDeath4.png", imgSize, imgSize, true, true);
        roadDeath1 = new Image(filePath + "carDeath1.png", imgSize, imgSize, true, true);
        roadDeath2 = new Image(filePath + "carDeath2.png", imgSize, imgSize, true, true);
        roadDeath3 = new Image(filePath + "carDeath3.png", imgSize, imgSize, true, true);
    }

    public void keyBoardPress(KeyCode pressedKey){
        if(this.model.noMove)
            return;
        if(moveComplete){
            switch (pressedKey){
                case W:
                    move(0, -movementY);
                    setImage(imgUp);
                    moveComplete = false;
                    break;

                case A:
                    move(-movementX, 0);
                    setImage(imgLeft);
                    moveComplete = false;
                    break;

                case S:
                    move(0, movementY);
                    setImage(imgDown);
                    moveComplete = false;
                    break;

                case D:
                    move(movementX, 0);
                    setImage(imgRight);
                    moveComplete = false;
                    break;

                default:
            }
        }else{
            switch (pressedKey){
                case W:
                    move(0, -movementY);
                    setImage(imgUpJump);
                    moveComplete = true;
                    break;

                case A:
                    move(-movementX, 0);
                    setImage(imgLeftJump);
                    moveComplete = true;
                    break;

                case S:
                    move(0, movementY);
                    setImage(imgDownJump);
                    moveComplete = true;
                    break;

                case D:
                    move(movementX, 0);
                    setImage(imgRightJump);
                    moveComplete = true;
                    break;

                default:
            }
        }
    }

    public void keyBoardRelease(KeyCode releasedKey){
        switch (releasedKey) {
            case W:
                move(0, -movementY);
                setImage(imgUp);
                moveComplete = false;
                break;

            case A:
                move(-movementX, 0);
                setImage(imgLeft);
                moveComplete = false;
                break;

            case S:
                move(0, movementY);
                setImage(imgDown);
                moveComplete = false;
                break;

            case D:
                move(movementX, 0);
                setImage(imgRight);
                moveComplete = false;
                break;

            default:
            }
    }

    public boolean waterDeath(long timer){
        if ((timer)% timeInverval == 0) {
            deathFrame++;
        }
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
        if ((timer) % timeInverval == 0) {
            deathFrame++;
        }
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

    @Override
    public void act(long timer){
        if(this.model.status != FroggerModel.Status.ALIVE){
            if(this.model.status == FroggerModel.Status.ROADDEATH){
                if(roadDeath(timer)){
                    this.model.status = FroggerModel.Status.ALIVE;
                    this.model.noMove = false;
                    setBackToStart();
                }
            }else if(this.model.status == FroggerModel.Status.WATERDEATH){
                if(waterDeath(timer)){
                    this.model.status = FroggerModel.Status.ALIVE;
                    this.model.noMove = false;
                    setBackToStart();
                }
            }
        }else{
            checkStatus(timer);
        }
    }
}
