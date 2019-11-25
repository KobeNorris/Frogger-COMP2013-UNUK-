package main.Element.Platform.Turtle.WetTurtle;

import main.Element.Platform.PlatformController;

public class WetTurtleController extends PlatformController {
    private WetTurtleView view;
    private WetTurtleModel model;

    public WetTurtleController(int positionX, int positionY, double speed, double width, double height){
        this.model = new WetTurtleModel(speed);
        this.view = new WetTurtleView(positionX, positionY, width, height);
    }

    @Override
    public void act(long timer) {
        this.view.move(this.model.speed , 0);
        if (this.view.getX() > 600 && this.model.speed > 0)
            this.view.setX(-180);
        if (this.view.getX() < -300 && this.model.speed < 0)
            this.view.setX(700);
        if(view.turtleSwim(timer)){
            this.model.isSunk = true;
        }else{
            this.model.isSunk = false;
        }
    }

    @Override
    public WetTurtleView getView(){
        return this.view;
    }
}
