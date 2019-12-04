package main.java.com.platform.turtle.wetTurtle;

import main.java.Main;
import javafx.scene.image.Image;
import main.java.com.platform.PlatformView;

public class WetTurtleView extends PlatformView {
    private Image firstFrame, secondFrame, thirdFrame, fourthFrame;
//    private String filePathFirstFrame = "file:src/resource/img/Platform/Turtle/turtleAnimation1.png";
//    private String filePathSecondFrame = "file:src/resource/img/Platform/Turtle/turtleAnimation2Wet.png";
//    private String filePathThirdFrame = "file:src/resource/img/Platform/Turtle/turtleAnimation3Wet.png";
//    private String getFilePathFourthFrame = "file:src/resource/img/Platform/Turtle/turtleAnimation4Wet.png";

    private WetTurtleController controller;
    private WetTurtleModel model;

    public WetTurtleView(int positionX, int positionY, double width, double height, double speed) {
        createModel(speed);
        createController();

        this.firstFrame = new Image(this.model.getFilePath() + "turtleAnimation1.png", width, height, true, true);
        this.secondFrame = new Image(this.model.getFilePath() + "turtleAnimation2Wet.png", width, height, true, true);
        this.thirdFrame = new Image(this.model.getFilePath() + "turtleAnimation3Wet.png", width, height, true, true);
        this.fourthFrame = new Image(this.model.getFilePath() + "turtleAnimation4Wet.png", width, height, true, true);

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
        move(this.model.speed  * Main.diffficulty, 0);
        if (getX() > 700 && this.model.speed > 0)
            setX(-300);
        if (getX() < -300 && this.model.speed < 0)
            setX(700);
        turtleSwim(timer);
    }
}