package com.platform;

import com.Controller;

/**
 * The controller of Platform
 */
public class PlatformController implements Controller {
    protected PlatformModel model;

    protected PlatformController(){}

    /**
     * Initialise the internal model
     *
     * @param model Target internal model
     */
    public PlatformController(PlatformModel model){
        this.model = model;
    }
}
