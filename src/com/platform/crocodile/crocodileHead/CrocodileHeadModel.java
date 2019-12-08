package com.platform.crocodile.crocodileHead;

import com.platform.PlatformModel;

public class CrocodileHeadModel extends PlatformModel {
    private String filePath = "file:resources/img/Platform/Crocodile/";
    public double speed;

    public CrocodileHeadModel(double speed){
        this.speed = speed;
    }

    public String getFilePath(){return this.filePath;}
}
