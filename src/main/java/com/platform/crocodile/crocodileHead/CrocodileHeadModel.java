package main.java.com.platform.crocodile.crocodileHead;

import main.java.com.platform.PlatformModel;

public class CrocodileHeadModel extends PlatformModel {
    private String filePath = "file:resources/img/Platform/Crocodile/";
    public double speed;

    public CrocodileHeadModel(double speed){
        this.speed = speed;
    }

    public String getFilePath(){return this.filePath;}
}
