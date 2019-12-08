package com.background;

import com.Controller;

public class BackgroundImageController implements Controller {
    private final BackgroundImageModel model;

    public BackgroundImageController(BackgroundImageModel model){
        this.model = model;
    }
}