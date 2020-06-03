package com.platform;

import com.Controller;

/**
 * <h1>PlatformController</h1>
 *
 * <p>The {@link Controller} of PlatformView, enhancing the connection between PlatformView
 * and PlatformModel
 *
 * <p>
 * @author Kejia Wu, scykw1@nottingham.ac.uk
 * @version 1.2
 * @since 1.0
 * @see Controller
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
