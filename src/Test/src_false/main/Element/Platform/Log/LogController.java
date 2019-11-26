package main.Element.Platform.Log;

import main.Element.Platform.PlatformController;

public class LogController extends PlatformController {
    private LogView view;
    private LogModel model;
    private String imageLinkShort = "file:src/img/Platform/Log/shortLog.png";
    private String imageLinkMiddle = "file:src/img/Platform/Log/middleLog.png";
    private String imageLinkLong = "file:src/img/Platform/Log/longLog.png";

    public LogController(String type, int positionX, int positionY, double speed, double width, double height){
        this.model = new LogModel(speed);
        switch(type){
            case "long":
                this.view = new LogView(imageLinkLong, positionX, positionY, width, height);
                break;

            case "middle":
                this.view = new LogView(imageLinkMiddle, positionX, positionY, width, height);
                break;

            case "short":
                this.view = new LogView(imageLinkShort, positionX, positionY, width, height);
                break;

            default:
        }
    }

    @Override
    public void act(long timer) {
        this.view.move(this.model.speed , 0);
        if (this.view.getX() > 600 && this.model.speed > 0)
            this.view.setX(-180);
        if (this.view.getX() < -300 && this.model.speed < 0)
            this.view.setX(700);
    }

    @Override
    public LogView getView(){
        return this.view;
    }
}
