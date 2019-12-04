package main.java.com.obstacle.car;

import main.java.com.obstacle.ObstacleController;

public class CarController extends ObstacleController {
    private CarModel model;

    public CarController(CarModel model){
        this.model = model;
    }
}
