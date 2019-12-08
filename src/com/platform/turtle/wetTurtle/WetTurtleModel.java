package com.platform.turtle.wetTurtle;

import com.platform.PlatformModel;

public class WetTurtleModel extends PlatformModel {
    private String filePath = "file:resources/img/Platform/Turtle/";
    public double speed;

    public WetTurtleModel(double speed){
        this.speed = speed;
    }

    public String getFilePath(){return this.filePath;}
}