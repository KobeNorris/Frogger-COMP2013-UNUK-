package main.Element.Obstacle;

import main.Element.Controller;
import main.Element.Viewer;

public class ObstacleController extends Controller {
    private ObstacleViewer viewer;
    private ObstacleModel model;

    protected ObstacleController(){}

    public ObstacleController(String imageLink, int positionX, int positionY, double speed, double width, double height){
        this.model = new ObstacleModel(speed);
        this.viewer = new ObstacleViewer(imageLink, positionX, positionY, width, height);
    }

    @Override
    public void act(long timer){
        this.viewer.move(model.speed , 0);
        if ( this.viewer.getX() > 600 &&  this.model.speed > 0)
            this.viewer.setX(-200);
        if ( this.viewer.getX() < -50 &&  this.model.speed < 0)
            this.viewer.setX(600);
    }

    @Override
    public Viewer getViewer(){
        return this.viewer;
    }

}
