package com.obstacle;

import com.Controller;

/**
 * <h1>ObstacleController</h1>
 *
 * <p>The controller of Obstacles, containing a default constructor to initialise internal model
 * It extends from {@link Controller}
 *
 * <p>
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.4
 * @since 1.0
 * @see Controller
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
