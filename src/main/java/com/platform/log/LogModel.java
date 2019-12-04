package main.java.com.platform.log;

public class LogModel {
    private String filePath = "file:src/main/resources/img/Platform/Log/";
    public double speed;

    public LogModel(double speed){
        this.speed = speed;
    }

    public String getFilePath(){return this.filePath;}
}
