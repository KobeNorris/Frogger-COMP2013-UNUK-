package code.com.obstacle.truck.longTruck;

import code.Main;
import javafx.scene.image.Image;
import code.com.obstacle.ObstacleView;

public class LongTruckView extends ObstacleView {
    private Image LongTruckLeft, LongTruckRight;
    private LongTruckModel model;
    private LongTruckController controller;
    private String filePathToLongTruckLeft = "file:src/resource/img/Obstacle/Truck/longTruckLeft.png";
    private String filePathToLongTruckRight = "file:src/resource/img/Obstacle/Truck/longTruckRight.png";

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
    public void act(long timer) {
        move(this.model.speed  * Main.diffficulty, 0);
        if (getX() > 700 && this.model.speed > 0)
            setX(-300);
        if (getX() < -300 && this.model.speed < 0)
            setX(700);
    }
}
