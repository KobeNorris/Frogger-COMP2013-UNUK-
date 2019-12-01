package main.Element.Platform.Turtle.DryTurtle;

import javafx.scene.image.Image;
import main.Element.Platform.PlatformView;

public class DryTurtleView extends PlatformView {
    private Image firstFrame, secondFrame, thirdFrame;
    private String filePathFirstFrame = "file:src/resource/img/Platform/Turtle/turtleAnimation1.png";
    private String filePathSecondFrame = "file:src/resource/img/Platform/Turtle/turtleAnimation2.png";
    private String filePathThirdFrame = "file:src/resource/img/Platform/Turtle/turtleAnimation3.png";

    private DryTurtleController controller;
    private DryTurtleModel model;

    public DryTurtleView(double positionX, double positionY, double width, double height, double speed) {
        this.firstFrame = new Image(filePathFirstFrame, width, height, true, true);
        this.secondFrame = new Image(filePathSecondFrame, width, height, true, true);
        this.thirdFrame = new Image(filePathThirdFrame, width, height, true, true);

        createModel(speed);
        createController();

        setX(positionX);
        setY(positionY);
    }

    public void createModel(double speed){
        this.model = new DryTurtleModel(speed);
    }

    public void createController(){
        this.controller = new DryTurtleController(this.model);
    }

    public void turtleSwim(long timer){
        switch ((int)(timer/600000000 % 3)){
            case 0:
                setImage(this.firstFrame);
                break;

            case 1:
                setImage(this.secondFrame);
                break;

            case 2:
                setImage(this.thirdFrame);
                break;

            default:
        }
    }

    @Override
    public double getSpeed(){return this.model.speed;}

    @Override
    public void act(long timer) {
        move(this.model.speed , 0);
        if (getX() > 700 && this.model.speed > 0)
            setX(-300);
        if (getX() < -300 && this.model.speed < 0)
            setX(700);
        turtleSwim(timer);
    }
}
