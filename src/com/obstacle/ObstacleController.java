package com.obstacle;

import com.Controller;

/**
 * The controller of Obstacles, containing a default constructor to initialise internal model
 *
 * <p>
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.4
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
