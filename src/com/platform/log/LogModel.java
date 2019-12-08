package com.platform.log;

import com.platform.PlatformModel;

public class LogModel extends PlatformModel {
    private String filePath = "file:resources/img/Platform/Log/";
    public boolean isSunk = false;
    public double speed;

    public LogModel(double speed){
        this.speed = speed;
    }

    public String getFilePath(){return this.filePath;}
}
