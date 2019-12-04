package com.obstacle.car;

import main.Main;
import javafx.scene.image.Image;
import com.obstacle.ObstacleView;

public class CarView extends ObstacleView {
    private Image carLeft, carRight;
    private CarModel model;
    private CarController controller;
    private String filePathToCarRight = "file:src/resource/img/Obstacle/Car/carRight.png";
    private String filePathToCarLeft = "file:src/resource/img/Obstacle/Car/carLeft.png";
    
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

    @Override
    public void act(long timer) {
        move(this.model.speed  * Main.diffficulty, 0);
        if (getX() > 700 && this.model.speed > 0)
            setX(-300);
        if (getX() < -300 && this.model.speed < 0)
            setX(700);
    }
}
