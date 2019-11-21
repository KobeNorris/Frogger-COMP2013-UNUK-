package main.Element.Frogger;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import main.Element.Viewer;

public class FroggerViewer extends Viewer {
    private Image imgUp, imgLeft, imgRight, imgDown, imgUpJump, imgLeftJump, imgRightJump, imgDownJump;
    private Image waterDeath1, waterDeath2, waterDeath3, waterDeath4, roadDeath1, roadDeath2, roadDeath3;
    private String filePath = "file:src/img/FroggerAction/";
    private int imgSize = 40, timeInverval = 11;
    private double originPositionX, originPositionY;
    private double movementX, movementY;
    private boolean moveComplete = true;

    private FroggerController froggerController;

    private static FroggerViewer frogger = null;

    public static FroggerViewer getFrogger(){
        if(frogger == null)
            frogger = new FroggerViewer();
        return frogger;
    }

    public void init(){
        imgUp = new Image(filePath + "froggerUp.png", imgSize, imgSize, true, true);
        imgLeft = new Image(filePath + "froggerLeft.png", imgSize, imgSize, true, true);
        imgRight = new Image(filePath + "froggerDown.png", imgSize, imgSize, true, true);
        imgDown = new Image(filePath + "froggerRight.png", imgSize, imgSize, true, true);
        imgUpJump = new Image(filePath + "froggerUpJump.png", imgSize, imgSize, true, true);
        imgLeftJump = new Image(filePath + "froggerLeftJump.png", imgSize, imgSize, true, true);
        imgRightJump = new Image(filePath + "froggerDownJump.png", imgSize, imgSize, true, true);
        imgDownJump = new Image(filePath + "froggerRightJump.png", imgSize, imgSize, true, true);

        waterDeath1 = new Image(filePath + "waterDeath1.png", imgSize, imgSize, true, true);
        waterDeath2 = new Image(filePath + "waterDeath2.png", imgSize, imgSize, true, true);
        waterDeath3 = new Image(filePath + "waterDeath3.png", imgSize, imgSize, true, true);
        waterDeath4 = new Image(filePath + "waterDeath4.png", imgSize, imgSize, true, true);
        roadDeath1 = new Image(filePath + "carDeath1.png", imgSize, imgSize, true, true);
        roadDeath2 = new Image(filePath + "carDeath2.png", imgSize, imgSize, true, true);
        roadDeath3 = new Image(filePath + "carDeath3.png", imgSize, imgSize, true, true);

        movementY = 13.3333333 * 2;
        movementX = 10.666666 * 2;
        originPositionX = 280.0;
        originPositionY = 750.0 + movementY;

        setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event){
                event.getCode();
            }
        });

        setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                event.getCode();
            }
        });
    }

    public void setController(FroggerController froggerController){
        this.froggerController = froggerController;
    }

    public void setBackToStart(){
        setX(originPositionX);
        setY(originPositionY);
        setImage(imgUp);
    }

    public void keyBoardPress(KeyCode pressedKey){
        if(moveComplete){
            switch (pressedKey){
                case W:
                    move(0, -movementY);
                    setImage(imgUp);

                case A:
                    move(-movementX, 0);
                    setImage(imgLeft);

                case S:
                    move(0, movementY);
                    setImage(imgDown);

                case D:
                    move(movementX, 0);
                    setImage(imgRight);

                default:
                    moveComplete = false;
            }
        }else{
            switch (pressedKey){
                case W:
                    move(0, -movementY);
                    setImage(imgUpJump);

                case A:
                    move(-movementX, 0);
                    setImage(imgLeftJump);

                case S:
                    move(0, movementY);
                    setImage(imgDownJump);

                case D:
                    move(movementX, 0);
                    setImage(imgRightJump);

                default:
                    moveComplete = true;
            }
        }
    }

    public void keyBoardRelease(KeyCode releasedKey){
        switch (releasedKey) {
            case W:
                move(0, -movementY);
                setImage(imgUp);

            case A:
                move(-movementX, 0);
                setImage(imgLeft);

            case S:
                move(0, movementY);
                setImage(imgDown);

            case D:
                move(movementX, 0);
                setImage(imgRight);

            default:
                moveComplete = false;
            }
    }

    public boolean waterDeath(long timer){
        int deathFrame = 0;
        if ((timer)% timeInverval == 0) {
            deathFrame++;
        }
        switch(deathFrame) {
            case 1:
                setImage(waterDeath1);

            case 2:
                setImage(waterDeath2);

            case 3:
                setImage(waterDeath3);

            case 4:
                setImage(waterDeath4);

            case 5:
                setBackToStart();
                return true;

            default:
                return false;
        }
    }

    public boolean roadDeath(long timer) {
        int deathFrame = 0;
        if ((timer) % timeInverval == 0) {
            deathFrame++;
        }
        switch (deathFrame) {
            case 1:
                setImage(roadDeath1);

            case 2:
                setImage(roadDeath2);

            case 3:
                setImage(roadDeath3);

            case 4:
                setBackToStart();
                return true;

            default:
                return false;
        }
    }
}
