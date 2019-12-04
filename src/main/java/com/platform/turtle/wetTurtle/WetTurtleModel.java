package main.java.com.platform.turtle.wetTurtle;

import main.java.com.platform.PlatformModel;

public class WetTurtleModel extends PlatformModel {
    private String filePath = "file:src/main/resources/img/Platform/Turtle/";
    public double speed;

    public WetTurtleModel(double speed){
        this.speed = speed;
    }

    public String getFilePath(){return this.filePath;}
}