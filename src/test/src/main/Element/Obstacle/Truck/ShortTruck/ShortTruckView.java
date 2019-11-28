package main.Element.Obstacle.Truck.ShortTruck;

import javafx.scene.image.Image;
import main.Element.Obstacle.ObstacleView;

public class ShortTruckView extends ObstacleView {
    private Image ShortTruckLeft, ShortTruckRight;
    private ShortTruckModel model;
    private ShortTruckController controller;
    private String filePathToShortTruckRight = "file:src/img/Obstacle/Truck/shortTruckRight.png";
    private String filePathToShortTruckLeft = "file:src/img/Obstacle/Truck/shortTruckLeft.png";

    public ShortTruckView(String shortTruckType, double positionX, double positionY, double size, double speed) {
        creatShortTruckModel(speed);
        creatShortTruckController();
        ShortTruckRight = new Image(filePathToShortTruckRight, size, size, true, true);
        ShortTruckLeft = new Image(filePathToShortTruckLeft, size, size, true, true);
        if(shortTruckType.equals("right"))
            setImage(ShortTruckRight);
        else
            setImage(ShortTruckLeft);
        setX(positionX);
        setY(positionY);
    }

    public void creatShortTruckModel(double speed){
        this.model = new ShortTruckModel(speed);
    }

    public void creatShortTruckController(){
        this.controller = new ShortTruckController(this.model);
    }

    @Override
    public void act(long timer) {
        move(this.model.speed , 0);
        if (getX() > 700 && this.model.speed > 0)
            setX(-300);
        if (getX() < -300 && this.model.speed < 0)
            setX(700);
    }
}
