package main.Element.Frogger;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import main.Element.Controller;
import main.Element.*;
import main.Element.Obstacle.ObstacleView;
import main.Element.Platform.PlatformView;
import main.Element.Platform.Turtle.WetTurtle.WetTurtleView;

public class FroggerController extends Controller{
    private FroggerView view;
    private FroggerModel model;

    public FroggerController(){
        this.model = new FroggerModel();
        this.view = new FroggerView(this.model.filePath);

        view.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event){
                movePressInstruction(event.getCode());
            }
        });

        view.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                moveReleaseInstruction(event.getCode());
            }
        });
    }

    public void movePressInstruction(KeyCode pressedKey){
        if(this.model.noMove){
        }else{
            this.view.keyBoardPress(pressedKey);
            checkBoundary();
        }
    }

    public void moveReleaseInstruction(KeyCode pressedKey){
        if(this.model.noMove){
        }else{
            this.view.keyBoardRelease(pressedKey);
            checkPosition();
            checkBoundary();
        }
    }

    public void checkPosition(){
        double positionY = view.getY();
        if(model.presentHighestPosition > positionY){
            model.points += 10;
            model.presentHighestPosition = positionY;
            model.changeScore = true;
            // Change score
        }
    }

    public void checkBoundary(){
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

    public boolean checkDeath(long timer){
        if (this.view.getIntersectingObjects(ObstacleView.class).size() >= 1) {
            this.model.status = this.model.status.ROADDEATH;
            this.model.noMove = true;
            return true;
        }else if(this.view.getY() < 413){
            if (this.view.getIntersectingObjects(PlatformView.class).size() == 0){
                this.model.status = this.model.status.WATERDEATH;
                this.model.noMove = true;
                return true;
            }else if(this.view.getIntersectingObjects(WetTurtleView.class).size() >= 1 && (int)(timer/600000000 % 4) == 3){
                this.model.status = this.model.status.WATERDEATH;
                this.model.noMove = true;
                return true;
            }
        }
        return false;
    }

    @Override
    public void act(long timer){
        if(this.model.status != FroggerModel.Status.ALIVE){
            if(this.model.status == FroggerModel.Status.ROADDEATH){
                if(this.view.roadDeath(timer)){
                    this.model.status = FroggerModel.Status.ALIVE;
                    this.model.noMove = false;
                    this.view.setBackToStart();
                }
            }else if(this.model.status == FroggerModel.Status.WATERDEATH){
                if(this.view.waterDeath(timer)){
                    this.model.status = FroggerModel.Status.ALIVE;
                    this.model.noMove = false;
                    this.view.setBackToStart();
                }
            }
        }else{
            checkDeath(timer);
        }
    }

    @Override
    public View getView(){
        return this.view;
    }
}
