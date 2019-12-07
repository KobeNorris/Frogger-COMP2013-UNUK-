package main.java.com.platform.crocodile.crocodileBody;

import main.java.com.platform.PlatformModel;

public class CrocodileBodyModel extends PlatformModel {
    private String filePath = "file:resources/img/Platform/Crocodile/cro_body.png";
    public double speed;

    public CrocodileBodyModel(double speed){
        this.speed = speed;
    }

    public String getFilePath(){return this.filePath;}
}
