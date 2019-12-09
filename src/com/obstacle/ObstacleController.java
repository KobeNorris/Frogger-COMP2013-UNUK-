package com.obstacle;

import com.Controller;

/**
 * The controller of Obstacle
 */
public class ObstacleController implements Controller {
    protected ObstacleModel model;

    protected ObstacleController(){}

    /**
     * Initialise the internal model
     *
     * @param model Target internal model
     */
    public ObstacleController(ObstacleModel model){
        this.model = model;
    }
}
