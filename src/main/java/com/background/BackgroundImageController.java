package main.java.com.background;

import main.java.com.Controller;

public class BackgroundImageController implements Controller {
    private final BackgroundImageModel model;

    public BackgroundImageController(BackgroundImageModel model){
        this.model = model;
    }
}