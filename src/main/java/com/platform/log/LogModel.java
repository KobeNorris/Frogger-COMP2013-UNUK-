package main.java.com.platform.log;

import main.java.com.platform.PlatformModel;

public class LogModel extends PlatformModel {
    private String filePath = "file:src/main/resources/img/Platform/Log/";
    public boolean isSunk = false;
    public double speed;

    public LogModel(double speed){
        this.speed = speed;
    }

    public String getFilePath(){return this.filePath;}
}
