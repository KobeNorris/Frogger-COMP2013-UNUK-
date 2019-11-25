package main.Element.Platform.Log;

import main.Element.Platform.PlatformController;

public class LogController extends PlatformController {
    private LogViewer viewer;
    private LogModel model;
    private String imageLinkShort = "file:src/img/Platform/Log/shortLog.png";
    private String imageLinkMiddle = "file:src/img/Platform/Log/middleLog.png";
    private String imageLinkLong = "file:src/img/Platform/Log/longLog.png";

    public LogController(String type, int positionX, int positionY, double speed, double width, double height){
        this.model = new LogModel(speed);
        switch(type){
            case "long":
                this.viewer = new LogViewer(imageLinkLong, positionX, positionY, width, height);
                break;

            case "middle":
                this.viewer = new LogViewer(imageLinkMiddle, positionX, positionY, width, height);
                break;

            case "short":
                this.viewer = new LogViewer(imageLinkShort, positionX, positionY, width, height);
                break;

            default:
        }
    }

    @Override
    public void act(long timer) {
        this.viewer.move(this.model.speed , 0);
        if (this.viewer.getX() > 600 && this.model.speed > 0)
            this.viewer.setX(-180);
        if (this.viewer.getX() < -300 && this.model.speed < 0)
            this.viewer.setX(700);
    }

    @Override
    public LogViewer getViewer(){
        return this.viewer;
    }
}
