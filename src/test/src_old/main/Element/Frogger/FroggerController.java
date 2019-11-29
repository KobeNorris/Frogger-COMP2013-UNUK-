package main.Element.Frogger;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import main.Element.Controller;
import main.Element.*;
//import main.Element.End.EndView;
//import main.Element.Obstacle.ObstacleView;
//import main.Element.Platform.PlatformView;
//import main.Element.Platform.Turtle.WetTurtle.WetTurtleView;

public class FroggerController extends Controller{
    private FroggerModel model;

    public FroggerController(FroggerModel model){
        this.model = model;
    }

//    public void checkPosition(){
//        double positionY = view.getY();
//        if(model.presentHighestPosition > positionY){
//            model.points += 10;
//            model.presentHighestPosition = positionY;
//            model.changeScore = true;
//            // Change score
//        }
//    }
//
//    public void checkBoundary(FroggerView view){
//        double positionX = view.getX();
//        double positionY = view.getY();
//
//        if(positionX > model.rightBound){
//            view.setX(model.rightBound);
//        }else if(positionX < model.leftBound){
//            view.setX(model.leftBound);
//        }
//
//        if(positionY < model.upBound){
//            view.setY(model.upBound);
//        }else if(positionY > model.bottomBound){
//            view.setY(model.bottomBound);
//        }
//    }

//    public boolean checkStatus(long timer, FroggerView view){
//        if (view.getIntersectingObjects(ObstacleView.class).size() >= 1) {
//            this.model.setStatus(FroggerModel.Status.ROADDEATH);
//            this.model.noMove = true;
//            return true;
//        }else if(view.getY() < 413){
////            if (view.getIntersectingObjects(PlatformView.class).size() == 0){
////                this.model.status = this.model.status.WATERDEATH;
////                this.model.noMove = true;
////                return true;
////            }else if(view.getIntersectingObjects(WetTurtleView.class).size() >= 1 && (int)(timer/600000000 % 4) == 3){
////                this.model.status = this.model.status.WATERDEATH;
////                this.model.noMove = true;
////                return true;
////            }else if(view.getIntersectingObjects(EndView.class).size() >= 1){
//////                if()
////            }
//        }
//        return false;
//    }
}
