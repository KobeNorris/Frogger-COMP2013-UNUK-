package main.Element.Obstacle.Car;

import main.Element.Obstacle.ObstacleController;

public class CarController extends ObstacleController {
    private CarModel model;

    public CarController(CarModel model){
        this.model = model;
    }
}
