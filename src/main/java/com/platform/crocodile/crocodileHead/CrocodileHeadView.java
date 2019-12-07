package main.java.com.platform.crocodile.crocodileHead;

import javafx.scene.image.Image;
import main.java.Main;
import main.java.com.platform.PlatformView;

public class CrocodileHeadView extends PlatformView {
    private Image mouthCloseFrame, mouthOpenFrame;

    private CrocodileHeadController controller;
    private CrocodileHeadModel model;

    public CrocodileHeadView(int positionX, int positionY, double width, double height, double speed) {
        createModel(speed);
        createController();

        this.mouthCloseFrame = new Image(this.model.getFilePath() + "cro_closed.png", width, height, true, true);
        this.mouthOpenFrame = new Image(this.model.getFilePath() + "cro_open.png", width, height, true, true);

        setX(positionX);
        setY(positionY);
    }

    public void createModel(double speed){
        this.model = new CrocodileHeadModel(speed);
    }

    public void createController(){
        this.controller = new CrocodileHeadController(this.model);
    }

    public void turtleSwim(long timer){
        switch ((int)(timer/600000000 % 2)){
            case 0:
                setImage(this.mouthCloseFrame);
                this.model.isSunk = false;
                break;

            case 1:
                setImage(this.mouthOpenFrame);
                this.model.isSunk = true;
                break;

            default:
        }
    }

    public boolean isSunk(){return this.model.isSunk;}

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
