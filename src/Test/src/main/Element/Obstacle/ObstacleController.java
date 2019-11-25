package main.Element.Obstacle;

import main.Element.Controller;
import main.Element.View;

public class ObstacleController extends Controller {
    private ObstacleView view;
    private ObstacleModel model;

    protected ObstacleController(){}

    public ObstacleController(String imageLink, int positionX, int positionY, double speed, double width, double height){
        this.model = new ObstacleModel(speed);
        this.view = new ObstacleView(imageLink, positionX, positionY, width, height);
    }

    @Override
    public void act(long timer){
        this.view.move(model.speed , 0);
        if ( this.view.getX() > 600 &&  this.model.speed > 0)
            this.view.setX(-200);
        if ( this.view.getX() < -50 &&  this.model.speed < 0)
            this.view.setX(600);
    }

    @Override
    public View getView(){
        return this.view;
    }

}
