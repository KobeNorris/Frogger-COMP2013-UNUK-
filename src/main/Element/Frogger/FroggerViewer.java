package main.Element.Frogger;

import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import main.Element.Viewer;

public class FroggerViewer extends Viewer {
    private Image imgUp, imgLeft, imgRight, imgDown, imgUpJump, imgLeftJump, imgRightJump, imgDownJump;
    private String filePath = "file:src/img/FroggerAction/";
    private int imgSize = 40;
    private double originPositionX, originPositionY;
    private double movementX, movementY;
    private boolean moveComplete = true, noMove = false;

    public FroggerViewer(){
        imgUp = new Image(filePath + "froggerUp.png", imgSize, imgSize, true, true);
        imgLeft = new Image(filePath + "froggerLeft.png", imgSize, imgSize, true, true);
        imgRight = new Image(filePath + "froggerDown.png", imgSize, imgSize, true, true);
        imgDown = new Image(filePath + "froggerRight.png", imgSize, imgSize, true, true);
        imgUpJump = new Image(filePath + "froggerUpJump.png", imgSize, imgSize, true, true);
        imgLeftJump = new Image(filePath + "froggerLeftJump.png", imgSize, imgSize, true, true);
        imgRightJump = new Image(filePath + "froggerDownJump.png", imgSize, imgSize, true, true);
        imgDownJump = new Image(filePath + "froggerRightJump.png", imgSize, imgSize, true, true);
        movementY = 13.3333333 * 2;
        movementX = 10.666666 * 2;
        originPositionX = 280.0;
        originPositionY = 750.0 + movementY;
    }

    public void setBackToStart(){
        setX(originPositionX);
        setY(originPositionY);
        setImage(imgUp);
    }

    public void keyBoardPress(KeyCode pressedKey){
        if (noMove) {

        } else{
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
    }

    public void keyBoardRelease(KeyCode releasedKey){

    }

    public void waterDeath(){

    }
}
