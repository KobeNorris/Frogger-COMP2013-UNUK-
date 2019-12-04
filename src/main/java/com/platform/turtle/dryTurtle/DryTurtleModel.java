package main.java.com.platform.turtle.dryTurtle;

import main.java.com.platform.PlatformModel;

public class DryTurtleModel extends PlatformModel {
    private String filePath = "file:src/main/resources/img/Platform/Turtle/";
    public double speed;

    public DryTurtleModel(double speed){
        this.speed = speed;
    }

    public String getFilePath(){return this.filePath;}
}
