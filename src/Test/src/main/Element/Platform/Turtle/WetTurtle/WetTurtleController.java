package main.Element.Platform.Turtle.WetTurtle;

import main.Element.Platform.PlatformController;

public class WetTurtleController extends PlatformController {
    private WetTurtleViewer viewer;
    private WetTurtleModel model;

    public WetTurtleController(int positionX, int positionY, double speed, double width, double height){
        this.model = new WetTurtleModel(speed);
        this.viewer = new WetTurtleViewer(positionX, positionY, width, height);
    }

    @Override
    public void act(long timer) {
        this.viewer.move(this.model.speed , 0);
        if (this.viewer.getX() > 600 && this.model.speed > 0)
            this.viewer.setX(-180);
        if (this.viewer.getX() < -300 && this.model.speed < 0)
            this.viewer.setX(700);
        if(viewer.turtleSwim(timer)){
            this.model.isSunk = true;
        }else{
            this.model.isSunk = false;
        }
    }

    @Override
    public WetTurtleViewer getViewer(){
        return this.viewer;
    }
}
