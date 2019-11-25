package main.Element.Obstacle.Truck.LongTruck;

import main.Element.Obstacle.ObstacleController;

public class LongTruckController extends ObstacleController {
    private LongTruckView view;
    private LongTruckModel model;
    private String imageLinkLeft = "file:src/img/Obstacle/Truck/truck2Left.png";
    private String imageLinkRight = "file:src/img/Obstacle/Truck/truck2Right.png";

    public LongTruckController(String type, int positionX, int positionY, double speed, double width, double height){
        this.model = new LongTruckModel(speed);
        if(type.equals("left")){
            this.view = new LongTruckView(imageLinkLeft, positionX, positionY, width, height);
        }else if(type.equals("right")){
            this.view = new LongTruckView(imageLinkRight, positionX, positionY, width, height);
        }
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
    public LongTruckView getView(){
        return this.view;
    }
}
