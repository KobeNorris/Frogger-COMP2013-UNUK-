package main.Element.Obstacle.Car;

import main.Element.Obstacle.ObstacleController;

public class CarController extends ObstacleController {
    private CarModel model;
    private CarViewer viewer;
    private String imageLinkLeft = "file:src/img/Obstacle/Car/car1Left.png";
    private String imageLinkRight = "file:src/img/Obstacle/Car/car1Right.png";

    public CarController(String type, int positionX, int positionY, double speed, double width, double height){
        this.model = new CarModel(speed);
        if(type.equals("left")){
            this.viewer = new CarViewer(imageLinkLeft, positionX, positionY, width, height);
        }else if(type.equals("right")){
            this.viewer = new CarViewer(imageLinkRight, positionX, positionY, width, height);
        }
    }

    @Override
    public void act(long timer){
        this.viewer.move(model.speed , 0);
        if (this.viewer.getX() > 600 &&  this.model.speed > 0)
            this.viewer.setX(-200);
        if (this.viewer.getX() < -50 &&  this.model.speed < 0)
            this.viewer.setX(600);
    }

    @Override
    public CarViewer getViewer() {
        return this.viewer;
    }
}
