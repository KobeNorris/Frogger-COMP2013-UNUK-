package main.Element.Obstacle.Car;

import main.Element.Obstacle.ObstacleController;

public class CarController extends ObstacleController {
    private CarModel model;
    private CarView view;
    private String imageLinkLeft = "file:src/img/Obstacle/Car/car1Left.png";
    private String imageLinkRight = "file:src/img/Obstacle/Car/car1Right.png";

    public CarController(String type, int positionX, int positionY, double speed, double width, double height){
        this.model = new CarModel(speed);
        if(type.equals("left")){
            this.view = new CarView(imageLinkLeft, positionX, positionY, width, height);
        }else if(type.equals("right")){
            this.view = new CarView(imageLinkRight, positionX, positionY, width, height);
        }
    }

    @Override
    public void act(long timer){
        this.view.move(model.speed , 0);
        if (this.view.getX() > 600 &&  this.model.speed > 0)
            this.view.setX(-200);
        if (this.view.getX() < -50 &&  this.model.speed < 0)
            this.view.setX(600);
    }

    @Override
    public CarView getView() {
        return this.view;
    }
}
