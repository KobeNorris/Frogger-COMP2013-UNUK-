package code.com.obstacle.car;

import code.com.obstacle.ObstacleController;

public class CarController extends ObstacleController {
    private CarModel model;

    public CarController(CarModel model){
        this.model = model;
    }
}
