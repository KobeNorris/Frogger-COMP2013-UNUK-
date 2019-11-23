package main.Element.Obstacle.Truck.LongTruck;

import main.Element.Obstacle.ObstacleController;

public class LongTruckController extends ObstacleController {
    private LongTruckViewer viewer;
    private LongTruckModel model;
    private String imageLinkLeft = "file:src/img/Obstacle/Truck/truck2Left.png";
    private String imageLinkRight = "file:src/img/Obstacle/Truck/truck2Right.png";

    public LongTruckController(String type, int positionX, int positionY, double speed, double width, double height){
        this.model = new LongTruckModel(speed);
        if(type.equals("left")){
            this.viewer = new LongTruckViewer(imageLinkLeft, positionX, positionY, width, height);
        }else if(type.equals("right")){
            this.viewer = new LongTruckViewer(imageLinkRight, positionX, positionY, width, height);
        }
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
    public LongTruckViewer getViewer(){
        return this.viewer;
    }
}
