package com.background;

import com.Model;

public class BackgroundImageModel extends Model {
    private String filePathToBackgroundImage = "file:src/resource/img/Background/background.png";

    public String getFilePathToBackgroundImage(){return this.filePathToBackgroundImage;}
}