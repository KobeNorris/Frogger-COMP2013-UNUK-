package main.java.com.score;

import javafx.scene.image.Image;
import main.java.com.View;

public class DigitView extends View {
    private Image digits[];
    private String filePath = "file:src/main/resources/img/Digit/";

    public DigitView(double positionX, double positionY, double size){
        digits = new Image[10];
        for(int iTemp = 0; iTemp < 10; iTemp++){
            digits[iTemp] = new Image(filePath + iTemp + ".png", size, size, true, true);
        }
        setImage(digits[0]);

        setX(positionX);
        setY(positionY);
    }

    public void setDigit(int digit){
        setImage(digits[digit]);
    }

    @Override
    public void act(long timer){}
}
