package main.Element.Platform;

import main.Element.Controller;
import main.Element.Viewer;

public class PlatformController extends Controller {
    private PlatformViewer viewer;
    private PlatformModel model;

    protected PlatformController(){}

    public PlatformController(String imageLink, int positionX, int positionY, int speed, double width, double height){
        this.model = new PlatformModel(speed);
        this.viewer = new PlatformViewer(imageLink, positionX, positionY, width, height);
    }

    @Override
    public void act(long timer){
        viewer.move(model.speed , 0);
        if (viewer.getX() > 600 && model.speed > 0)
            viewer.setX(-200);
        if (viewer.getX() < -50 && model.speed < 0)
            viewer.setX(600);
    }

    @Override
    public Viewer getViewer(){
        return this.viewer;
    }

}
