package main.Element.Platform.Turtle.DryTurtle;

import main.Element.Platform.PlatformController;

public class DryTurtleController extends PlatformController {
    private DryTurtleView view;
    private DryTurtleModel model;

    public DryTurtleController(int positionX, int positionY, double speed, double width, double height){
        this.model = new DryTurtleModel(speed);
        this.view = new DryTurtleView(positionX, positionY, width, height);
    }

    @Override
    public void act(long timer) {
        this.view.move(this.model.speed , 0);
        if (this.view.getX() > 600 && this.model.speed > 0)
            this.view.setX(-180);
        if (this.view.getX() < -300 && this.model.speed < 0)
            this.view.setX(700);
        view.turtleSwim(timer);
    }

    @Override
    public DryTurtleView getView(){
        return this.view;
    }
}
