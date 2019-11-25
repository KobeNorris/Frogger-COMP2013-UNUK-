package main.Element.Frogger;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import main.Element.Controller;
import main.Element.*;
import main.Element.Frogger.*;
import main.Element.Obstacle.ObstacleViewer;
import main.Element.Platform.PlatformViewer;
import main.Element.Platform.Turtle.WetTurtle.WetTurtleViewer;

public class FroggerController extends Controller{
    private FroggerViewer viewer;
    private FroggerModel model;

    @Override
    public void act(long timer){
        if(checkDeath(timer)){

        }
    }

    @Override
    public Viewer getViewer(){
        return this.viewer;
    }

    public FroggerController(){
        this.model = new FroggerModel();
        this.viewer = new FroggerViewer("file:src/img/FroggerAction/");

        viewer.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event){
                movePressInstruction(event.getCode());
            }
        });

        viewer.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                moveReleaseInstruction(event.getCode());
            }
        });

        this.viewer.init();
    }

    public void movePressInstruction(KeyCode pressedKey){
        if(this.model.noMove){

        }else{
            this.viewer.keyBoardPress(pressedKey);
            checkBoundary();
        }
    }

    public void moveReleaseInstruction(KeyCode pressedKey){
        if(this.model.noMove){

        }else{
            this.viewer.keyBoardRelease(pressedKey);
            checkPosition();
            checkBoundary();
        }
    }

    public void checkPosition(){
        double positionY = viewer.getY();
        if(model.presentHighestPosition > positionY){
            model.points += 10;
            model.presentHighestPosition = positionY;
            model.changeScore = true;
            // Change score
        }
    }

    public void checkBoundary(){
        double positionX = viewer.getX();
        double positionY = viewer.getY();

        if(positionX > model.rightBound){
            viewer.setX(model.rightBound);
        }else if(positionX < model.leftBound){
            viewer.setX(model.leftBound);
        }

        if(positionY < model.upBound){
            viewer.setY(model.upBound);
        }else if(positionY > model.bottomBound){
            viewer.setY(model.bottomBound);
        }
    }

    public boolean checkDeath(long timer){
        if (this.viewer.getIntersectingObjects(ObstacleViewer.class).size() >= 1) {
            this.model.status = this.model.status.ROADDEATH;
            this.model.noMove = true;
            System.out.println("1");
            return true;
        }else if(this.viewer.getY() < 413){
            if (this.viewer.getIntersectingObjects(PlatformViewer.class).size() == 0){
                this.model.status = this.model.status.WATERDEATH;
                this.model.noMove = true;
                System.out.println("2");
                return true;
            }else if(this.viewer.getIntersectingObjects(WetTurtleViewer.class).size() >= 1 && (int)(timer/600000000 % 4) == 3){
                this.model.status = this.model.status.WATERDEATH;
                this.model.noMove = true;
                System.out.println("3");
                return true;
            }
        }
        return false;
    }

}
