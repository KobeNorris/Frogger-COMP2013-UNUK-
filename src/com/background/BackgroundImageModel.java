package com.background;

import com.Model;

public class BackgroundImageModel implements Model {
    private String filePathToBackgroundImage = "file:resources/img/Background/background.png";

    public String getFilePathToBackgroundImage(){return this.filePathToBackgroundImage;}
}