package main.Element.Obstacle.Car;

import javafx.scene.image.Image;
import main.Element.Obstacle.ObstacleView;

public class CarView extends ObstacleView {
    private Image carLeft, carRight;
    private CarModel model;
    private CarController controller;
    private String filePathToCarRight = "file:src/img/Obstacle/Car/carRight.png";
    private String filePathToCarLeft = "file:src/img/Obstacle/Car/carLeft.png";
    
    public CarView(String carType, double positionX, double positionY, double size, double speed) {
        creatCarModel(speed);
        creatCarController();
        carRight = new Image(filePathToCarRight, size, size, true, true);
        carLeft = new Image(filePathToCarLeft, size, size, true, true);
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

    public void act(long timer){
        move(this.model.speed , 0);
        if (getX() > 600 &&  this.model.speed > 0)
            setX(-200);
        if (getX() < -50 &&  this.model.speed < 0)
            setX(600);
    }
}
