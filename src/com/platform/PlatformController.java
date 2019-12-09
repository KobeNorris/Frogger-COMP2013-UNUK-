package com.platform;

import com.Controller;

public class PlatformController implements Controller {
    protected PlatformModel model;

    protected PlatformController(){}

    public PlatformController(PlatformModel model){
        this.model = model;
    }
}
