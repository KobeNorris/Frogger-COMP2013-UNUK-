package main.Element.Obstacle.Truck.ShortTruck;

import main.Element.Obstacle.ObstacleController;

public class ShortTruckController extends ObstacleController {
    private ShortTruckView view;
    private ShortTruckModel model;
    private String imageLinkLeft = "file:src/img/Obstacle/Truck/truck1Left.png";
    private String imageLinkRight = "file:src/img/Obstacle/Truck/truck1Right.png";

    public ShortTruckController(String type, int positionX, int positionY, double speed, double width, double height){
        this.model = new ShortTruckModel(speed);
        if(type.equals("left")){
            this.view = new ShortTruckView(imageLinkLeft, positionX, positionY, width, height);
        }else if(type.equals("right")){
            this.view = new ShortTruckView(imageLinkRight, positionX, positionY, width, height);
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
    public ShortTruckView getView(){
        return this.view;
    }
}
