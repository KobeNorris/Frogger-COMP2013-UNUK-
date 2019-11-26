package main.Element.Platform;

public class PlatformModel {
    public int speed;
    public boolean isSunk = false;

    protected PlatformModel(){};

    public PlatformModel(int speed){
        this.speed = speed;
    }
}
