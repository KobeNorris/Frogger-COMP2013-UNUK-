package com.obstacle;

import com.Controller;

public class ObstacleController implements Controller {
    protected ObstacleModel model;

    protected ObstacleController(){}

    public ObstacleController(ObstacleModel model){
        this.model = model;
    }
}
