package main.Element.Platform.Turtle.WetTurtle;

import javafx.scene.image.Image;
import main.Element.Platform.PlatformView;

public class WetTurtleView extends PlatformView {
    private Image firstFrame, secondFrame, thirdFrame, fourthFrame;
    private String filePathFirstFrame = "file:src/resource/img/Platform/Turtle/turtleAnimation1.png";
    private String filePathSecondFrame = "file:src/resource/img/Platform/Turtle/turtleAnimation2Wet.png";
    private String filePathThirdFrame = "file:src/resource/img/Platform/Turtle/turtleAnimation3Wet.png";
    private String getFilePathFourthFrame = "file:src/resource/img/Platform/Turtle/turtleAnimation4Wet.png";

    private WetTurtleController controller;
    private WetTurtleModel model;

    public WetTurtleView(int positionX, int positionY, double width, double height, double speed) {
        this.firstFrame = new Image(filePathFirstFrame, width, height, true, true);
        this.secondFrame = new Image(filePathSecondFrame, width, height, true, true);
        this.thirdFrame = new Image(filePathThirdFrame, width, height, true, true);
        this.fourthFrame = new Image(getFilePathFourthFrame, width, height, true, true);

        createModel(speed);
        createController();

        setX(positionX);
        setY(positionY);
    }

    public void createModel(double speed){
        this.model = new WetTurtleModel(speed);
    }

    public void createController(){
        this.controller = new WetTurtleController(this.model);
    }

    public void turtleSwim(long timer){
        switch ((int)(timer/600000000 % 4)){
            case 0:
                setImage(this.firstFrame);
                this.model.isSunk = false;
                break;

            case 1:
                setImage(this.secondFrame);
                this.model.isSunk = false;
                break;

            case 2:
                setImage(this.thirdFrame);
                this.model.isSunk = false;
                break;

            case 3:
                setImage(this.fourthFrame);
                this.model.isSunk = true;

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