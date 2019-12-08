package com.obstacle.car;

import com.obstacle.ObstacleController;

public class CarController extends ObstacleController {
    private CarModel model;

    public CarController(CarModel model){
        this.model = model;
    }
}
