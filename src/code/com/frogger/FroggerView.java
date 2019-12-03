package code.com.frogger;

import code.com.obstacle.ObstacleView;
import code.com.platform.PlatformView;
import code.com.platform.turtle.wetTurtle.WetTurtleView;
import code.stageController.gameController.HardGameController;
import code.stageController.gameController.InfiniteGameController;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import code.com.end.EndView;
import code.com.View;
import code.Main;

public class FroggerView extends View {
    private Image imgUp, imgLeft, imgRight, imgDown, imgUpJump, imgLeftJump, imgRightJump, imgDownJump;
    private Image waterDeath1, waterDeath2, waterDeath3, waterDeath4, roadDeath1, roadDeath2, roadDeath3;
    private String filePath = "file:src/resource/img/FroggerAction/";
    private int imgSize = 40, timeInverval = 11;
    private double originPositionX, originPositionY;
    private double movementX = 10.666666 * 2, movementY = 13.45 * 2;
    private boolean moveComplete = false, jumpComplete = false;
    private int deathFrame = 0;
    private KeyCode previousKey;

    private static FroggerView view = null;
    private FroggerController controller;
    private FroggerModel model;

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
        moveComplete = false;
        jumpComplete = false;
        deathFrame = 0;
        setImage(imgUp);
    }

    public void enableChangeEnd(){
        if(Main.getPresentMode().equals("Hard")){
            HardGameController.changeEnd();
        }else if(Main.getPresentMode().equals("Infinite")){
            InfiniteGameController.changeEnd();
        }
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
                move(getIntersectingObjects(PlatformView.class).get(0).getSpeed() * Main.diffficulty , 0);
                if(getIntersectingObjects(WetTurtleView.class).size() >= 1 && (int)(timer/600000000 % 4) == 3){
                    this.model.setStatus(FroggerModel.Status.WATERDEATH);
                    this.model.noMove = true;
                    return true;
                }else if(getIntersectingObjects(EndView.class).size() >= 1){
                    EndView tempEndView = getIntersectingObjects(EndView.class).get(0);
                    if(tempEndView.checkStatusFROGOCCUPIED()){
                        this.model.setStatus(FroggerModel.Status.WATERDEATH);
                        this.model.noMove = true;
                        return true;
                    }else if(tempEndView.checkStatusCROCOCCUPIED()){
                        this.model.setStatus(FroggerModel.Status.ROADDEATH);
                        this.model.noMove = true;
                        return true;
                    }else{
                        previousKey = null;
                        if(tempEndView.checkStatusBUGOCCUPIED())
                            this.controller.bonusPoints();
                        tempEndView.occupyEnd("frog");
                        enableChangeEnd();
                        setBackToStart();
                        this.model.presentHighestPosition = 800;
                        if(++this.model.reachedEnd >= 5){
                            this.model.reachedEnd = 0;
                            if(Main.getPresentMode().equals("Infinite")){
                                InfiniteGameController.resetGame();
                            }else{
                                this.model.noMove = true;
                                this.model.stop = true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public void resetToStart(){this.controller.resetToStart();}

    public void resetPresentHighestPosition(){this.model.presentHighestPosition = 800;}

    public int getPoints(){
        return this.model.getPoints();
    }

    public void resetPoints(){
        this.model.setPoints(0);
    }

    public int getLife(){
        return this.model.life;
    }

    public boolean getStop(){
        return this.model.stop;
    }

    public  boolean checkScore(){
        if(model.changeScore){
            model.changeScore = false;
            return true;
        }else
            return false;
    }

    public  boolean checkLife(){
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
            checkStatus(timer);
        }
    }
}
