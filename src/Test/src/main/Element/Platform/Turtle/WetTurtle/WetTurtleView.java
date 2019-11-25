package main.Element.Platform.Turtle.WetTurtle;

import javafx.scene.image.Image;
import main.Element.Platform.PlatformView;

public class WetTurtleView extends PlatformView {
    private Image firstFrame, secondFrame, thirdFrame, fourthFrame;
    private String filePathFirstFrame = "file:src/img/Platform/Turtle/turtleAnimation1.png";
    private String filePathSecondFrame = "file:src/img/Platform/Turtle/turtleAnimation2Wet.png";
    private String filePathThirdFrame = "file:src/img/Platform/Turtle/turtleAnimation3Wet.png";
    private String getFilePathFourthFrame = "file:src/img/Platform/Turtle/turtleAnimation4Wet.png";

    public WetTurtleView(int positionX, int positionY, double width, double height) {
        this.firstFrame = new Image(filePathFirstFrame, width, height, true, true);
        this.secondFrame = new Image(filePathSecondFrame, width, height, true, true);
        this.thirdFrame = new Image(filePathThirdFrame, width, height, true, true);
        this.fourthFrame = new Image(getFilePathFourthFrame, width, height, true, true);

        setX(positionX);
        setY(positionY);
    }

    public boolean turtleSwim(long timer){
        switch ((int)(timer/600000000 % 4)){
            case 0:
                setImage(this.firstFrame);
                break;

            case 1:
                setImage(this.secondFrame);
                break;

            case 2:
                setImage(this.thirdFrame);
                break;

            case 3:
                setImage(this.fourthFrame);
                return false;

            default:
        }
        return true;
    }
}