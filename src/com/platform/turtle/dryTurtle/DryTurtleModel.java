package com.platform.turtle.dryTurtle;

import com.platform.PlatformModel;

public class DryTurtleModel extends PlatformModel {
    private String filePath = "file:resources/img/Platform/Turtle/";
    public double speed;

    public DryTurtleModel(double speed){
        this.speed = speed;
    }

    public String getFilePath(){return this.filePath;}
}
