package main.Element.Obstacle.Truck.LongTruck;

import javafx.scene.image.Image;
import main.Element.Obstacle.ObstacleView;

public class LongTruckView extends ObstacleView {
    private Image LongTruckLeft, LongTruckRight;
    private LongTruckModel model;
    private LongTruckController controller;
    private String filePathToLongTruckLeft = "file:src/img/Obstacle/Truck/longTruckLeft.png";
    private String filePathToLongTruckRight = "file:src/img/Obstacle/Truck/longTruckRight.png";

    public LongTruckView(String longTruckType, double positionX, double positionY, double size, double speed) {
        creatLongTruckModel(speed);
        creatLongTruckController();
        LongTruckRight = new Image(filePathToLongTruckRight, size, size, true, true);
        LongTruckLeft = new Image(filePathToLongTruckLeft, size, size, true, true);
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
    public void act(long timer){
        move(this.model.speed , 0);
        if (getX() > 600 &&  this.model.speed > 0)
            setX(-200);
        if (getX() < -50 &&  this.model.speed < 0)
            setX(600);
    }
}
