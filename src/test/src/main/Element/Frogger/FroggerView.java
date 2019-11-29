package main.Element.Frogger;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import main.Element.End.EndModel;
import main.Element.End.EndView;
import main.Element.Obstacle.ObstacleView;
import main.Element.Platform.PlatformView;
import main.Element.Platform.Turtle.WetTurtle.WetTurtleView;
import main.Element.View;

public class FroggerView extends View {
    private Image imgUp, imgLeft, imgRight, imgDown, imgUpJump, imgLeftJump, imgRightJump, imgDownJump;
    private Image waterDeath1, waterDeath2, waterDeath3, waterDeath4, roadDeath1, roadDeath2, roadDeath3;
    private String filePath = "file:src/img/FroggerAction/";
    private int imgSize = 40, timeInverval = 11;
    private double originPositionX, originPositionY;
    private double movementX = 10.666666 * 2, movementY = 13.45 * 2;
    private boolean moveComplete = false, jumpComplete = false;
    private int deathFrame = 0;

    private FroggerController controller;
    private static FroggerModel model;


    public FroggerView(){
        originPositionX = 280.0;
        originPositionY = 730.0 + movementY;
        createModel();
        createController();
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

    public static boolean checkReachedEnd(){return FroggerView.model.reachedEnd==5; }

    public void createModel(){
        this.model = new FroggerModel();
    }

    public void createController(){
        this.controller = new FroggerController(this.model);
    }

    public void setBackToStart(){
        setX(originPositionX);
        setY(originPositionY);
        moveComplete = false;
        jumpComplete = false;
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
        if(!this.model.noMove){
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

//                        //Space to pause()
//                    case SPACE:
//                        this.model.noMove = true;
////                        this.model.pause = true;
////                        checkPause();

                    default:
                }
                moveComplete = false;
                jumpComplete = false;
            }else{
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
        if(!this.model.noMove){
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
        if ((timer)% timeInverval == 0)
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
        if ((timer) % timeInverval == 0)
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

    public boolean checkStatus(long timer){
        controller.checkBoundary(this);
        if (getIntersectingObjects(ObstacleView.class).size() >= 1) {
            this.model.setStatus(FroggerModel.Status.ROADDEATH);
            this.model.noMove = true;
            return true;
        }else if(getY() < 413){
            if (getIntersectingObjects(PlatformView.class).size() == 0){
                this.model.setStatus(FroggerModel.Status.WATERDEATH);
                this.model.noMove = true;
                return true;
            }else{
                move(getIntersectingObjects(PlatformView.class).get(0).getSpeed() , 0);
                if(getIntersectingObjects(WetTurtleView.class).size() >= 1 && (int)(timer/600000000 % 4) == 3){
                    this.model.setStatus(FroggerModel.Status.WATERDEATH);
                    this.model.noMove = true;
                    return true;
                }else if(getIntersectingObjects(EndView.class).size() >= 1){
                    if(!getIntersectingObjects(EndView.class).get(0).checkStatus()){
                        this.model.setStatus(FroggerModel.Status.WATERDEATH);
                        this.model.noMove = true;
                        return true;
                    }else{
                        getIntersectingObjects(EndView.class).get(0).occupyEnd();
                        setBackToStart();
                        this.model.presentHighestPosition = 800;
                        if(++this.model.reachedEnd >= 1){
                            this.model.noMove = true;
                            this.model.stop = true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static int getPoints(){
        return FroggerView.model.points;
    }

    public static int getLife(){
        return FroggerView.model.life;
    }

    public static boolean getStop(){
        return FroggerView.model.stop;
    }

    public static boolean checkScore(){
        if(model.changeScore){
            model.changeScore = false;
            return true;
        }else
            return false;
    }

    public static boolean checkLife(){
        if(model.changeLife){
            model.changeLife = false;
            return true;
        }else
            return false;
    }

    @Override
    public void act(long timer){
        FroggerModel.Status status = this.model.getStatus();
        if( status != FroggerModel.Status.ALIVE){
            if( status == FroggerModel.Status.ROADDEATH){
                if(roadDeath(timer)){
                    this.controller.revive();
                    model.changeScore = true;
                    setBackToStart();
                }
            }else if(status == FroggerModel.Status.WATERDEATH){
                if(waterDeath(timer)){
                    this.controller.revive();
                    model.changeScore = true;
                    setBackToStart();
                }
            }
        }else{
            checkStatus(timer);
        }
    }
}
