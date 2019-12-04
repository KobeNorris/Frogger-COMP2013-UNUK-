package main.java.com.obstacle.car;

import main.java.Main;
import javafx.scene.image.Image;
import main.java.com.obstacle.ObstacleView;

public class CarView extends ObstacleView {
    private Image carLeft, carRight;
    private CarModel model;
    private CarController controller;
    
    public CarView(String carType, double positionX, double positionY, double size, double speed) {
        creatCarModel(speed);
        creatCarController();
        carRight = new Image(this.model.getFilePath()+"carRight.png", size, size, true, true);
        carLeft = new Image(this.model.getFilePath()+"carLeft.png", size, size, true, true);
        if(carType.equals("right"))
            setImage(carRight);
        else
            setImage(carLeft);
        setX(positionX);
        setY(positionY);
    }

    public void creatCarModel(double speed){
        this.model = new CarModel(speed);
    }

    public void creatCarController(){
        this.controller = new CarController(this.model);
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
