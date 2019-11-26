package main.Element.Platform.Turtle.DryTurtle;

import javafx.scene.image.Image;
import main.Element.Platform.PlatformView;

public class DryTurtleView extends PlatformView {
    private Image firstFrame, secondFrame, thirdFrame;
    private String filePathFirstFrame = "file:src/img/Platform/Turtle/turtleAnimation1.png";
    private String filePathSecondFrame = "file:src/img/Platform/Turtle/turtleAnimation2.png";
    private String filePathThirdFrame = "file:src/img/Platform/Turtle/turtleAnimation3.png";

    public DryTurtleView(int positionX, int positionY, double width, double height) {
        this.firstFrame = new Image(filePathFirstFrame, width, height, true, true);
        this.secondFrame = new Image(filePathSecondFrame, width, height, true, true);
        this.thirdFrame = new Image(filePathThirdFrame, width, height, true, true);

        setX(positionX);
        setY(positionY);
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
}
