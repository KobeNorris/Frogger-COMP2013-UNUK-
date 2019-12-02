package code.com.platform.log;

import code.Main;
import javafx.scene.image.Image;
import code.com.platform.PlatformView;

public class LogView extends PlatformView {
    private LogModel model;
    private LogController controller;
    private String imageLinkShort = "file:src/resource/img/Platform/Log/shortLog.png";
    private String imageLinkMiddle = "file:src/resource/img/Platform/Log/middleLog.png";
    private String imageLinkLong = "file:src/resource/img/Platform/Log/longLog.png";

    public LogView(String type, double positionX, double positionY, double width, double height, double speed) {
        switch(type){
            case "long":
                setImage(new Image(imageLinkLong, width, height, true, true));
                break;

            case "middle":
                setImage(new Image(imageLinkMiddle, width, height, true, true));
                break;

            case "short":
                setImage(new Image(imageLinkShort, width, height, true, true));
                break;

            default:
        }
        setX(positionX);
        setY(positionY);

        createModel(speed);
        createController();
    }

    public void createModel(double speed){
        this.model = new LogModel(speed);
    }

    public void createController(){
        this.controller = new LogController(this.model);
    }

    @Override
    public double getSpeed(){return this.model.speed;}

    @Override
    public void act(long timer) {
        move(this.model.speed  * Main.diffficulty, 0);
        if (getX() > 700 && this.model.speed > 0)
            setX(-300);
        if (getX() < -300 && this.model.speed < 0)
            setX(700);
    }
}
