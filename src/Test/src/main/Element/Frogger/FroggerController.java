package main.Element.Frogger;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import main.Element.Controller;
import main.Element.*;
import main.Element.Frogger.*;

public class FroggerController extends Controller{
    private FroggerViewer froggerViewer;
    private FroggerModel froggerModel;

    @Override
    public void act(long timer){}

    @Override
    public Viewer getViewer(){
        return this.froggerViewer;
    }

    public FroggerController(){
        this.froggerModel = new FroggerModel();
        this.froggerViewer = new FroggerViewer("file:src/img/FroggerAction/");

        froggerViewer.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event){
                movePressInstruction(event.getCode());
            }
        });

        froggerViewer.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                moveReleaseInstruction(event.getCode());
            }
        });

        this.froggerViewer.init();
    }

    public void movePressInstruction(KeyCode pressedKey){
        if(this.froggerModel.noMove){

        }else{
            this.froggerViewer.keyBoardPress(pressedKey);
            checkDeath();
            checkBoundary();
        }
    }

    public void moveReleaseInstruction(KeyCode pressedKey){
        if(this.froggerModel.noMove){

        }else{
            this.froggerViewer.keyBoardRelease(pressedKey);
            checkPosition();
            checkDeath();
            checkBoundary();
        }
    }

    public void checkPosition(){
        double positionY = froggerViewer.getY();
        if(froggerModel.presentHighestPosition > positionY){
            froggerModel.points += 10;
            froggerModel.presentHighestPosition = positionY;
            froggerModel.changeScore = true;
            // Change score
        }
    }

    public void checkBoundary(){
        double positionX = froggerViewer.getX();
        double positionY = froggerViewer.getY();

        if(positionX > froggerModel.rightBound){
            froggerViewer.setX(froggerModel.rightBound);
        }else if(positionX < froggerModel.leftBound){
            froggerViewer.setX(froggerModel.leftBound);
        }

        if(positionY < froggerModel.upBound){
            froggerViewer.setY(froggerModel.upBound);
        }else if(positionY > froggerModel.bottomBound){
            froggerViewer.setY(froggerModel.bottomBound);
        }
    }

    public void checkDeath(){
//        froggerViewer.getIntersectingObjects(Obstacle.class).size() >= 1
    }

}
