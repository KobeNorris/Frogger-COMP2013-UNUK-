package main.Element.Platform.Turtle.DryTurtle;

import main.Element.Platform.PlatformController;

public class DryTurtleController extends PlatformController {
    private DryTurtleViewer viewer;
    private DryTurtleModel model;
    private String imageLink = "file:src/img/Platform/Turtle/";

    public DryTurtleController(int positionX, int positionY, double speed, double width, double height){
        this.model = new DryTurtleModel(speed);
        this.viewer = new DryTurtleViewer(positionX, positionY, width, height);
    }

    @Override
    public void act(long timer) {
        this.viewer.move(this.model.speed , 0);
        if (this.viewer.getX() > 600 && this.model.speed > 0)
            this.viewer.setX(-180);
        if (this.viewer.getX() < -300 && this.model.speed < 0)
            this.viewer.setX(700);
        viewer.turtleSwim(timer);
    }

    @Override
    public DryTurtleViewer getViewer(){
        return this.viewer;
    }
}
