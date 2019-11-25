package main.Element.Platform;

import main.Element.Controller;
import main.Element.View;

public class PlatformController extends Controller {
    private PlatformView view;
    private PlatformModel model;

    protected PlatformController(){}

    public PlatformController(String imageLink, int positionX, int positionY, int speed, double width, double height){
        this.model = new PlatformModel(speed);
        this.view = new PlatformView(imageLink, positionX, positionY, width, height);
    }

    @Override
    public void act(long timer){
        view.move(model.speed , 0);
        if (view.getX() > 600 && model.speed > 0)
            view.setX(-200);
        if (view.getX() < -50 && model.speed < 0)
            view.setX(600);
    }

    @Override
    public View getView(){
        return this.view;
    }

}
