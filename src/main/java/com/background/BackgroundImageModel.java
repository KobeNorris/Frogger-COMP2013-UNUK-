package main.java.com.background;

import main.java.com.Model;

public class BackgroundImageModel extends Model {
    private String filePathToBackgroundImage = "file:src/main/resources/img/Background/background.png";

    public String getFilePathToBackgroundImage(){return this.filePathToBackgroundImage;}
}