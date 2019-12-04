package main.java.com.obstacle.truck.longTruck;

import main.java.Main;
import javafx.scene.image.Image;
import main.java.com.obstacle.ObstacleView;

public class LongTruckView extends ObstacleView {
    private Image LongTruckLeft, LongTruckRight;
    private LongTruckModel model;
    private LongTruckController controller;

    public LongTruckView(String longTruckType, double positionX, double positionY, double size, double speed) {
        creatLongTruckModel(speed);
        creatLongTruckController();
        LongTruckRight = new Image(this.model.getFilePath() + "longTruckRight.png", size, size, true, true);
        LongTruckLeft = new Image(this.model.getFilePath() + "longTruckLeft.png", size, size, true, true);
        if(longTruckType.equals("right"))
            setImage(LongTruckRight);
        else
            setImage(LongTruckLeft);
        setX(positionX);
        setY(positionY);
    }

    public void creatLongTruckModel(double speed){
        this.model = new LongTruckModel(speed);
    }

    public void creatLongTruckController(){
        this.controller = new LongTruckController(this.model);
    }

    @Override
    public void act(long timer) {
        move(this.model.speed  * Main.diffficulty, 0);
        if (getX() > 700 && this.model.speed > 0)
            setX(-300);
        if (getX() < -300 && this.model.speed < 0)
            setX(700);
    }
}
