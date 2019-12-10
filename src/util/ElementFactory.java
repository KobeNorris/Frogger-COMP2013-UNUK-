package util;

import com.end.EndView;
import com.frogger.FroggerView;
import com.obstacle.car.CarView;
import com.obstacle.snake.SnakeView;
import com.obstacle.truck.LongTruckView;
import com.obstacle.truck.ShortTruckView;
import com.platform.crocodile.CrocodileBodyView;
import com.platform.crocodile.CrocodileHeadView;
import com.platform.log.LogView;
import com.platform.turtle.DryTurtleView;
import com.platform.turtle.WetTurtleView;

public class ElementFactory {
    public static FroggerView froggerProvider(){
        return FroggerView.getFroggerView();
    }

    public static EndView endProvider(int positionX, int positionY, double width, double height){
        return new EndView(positionX, positionY, width, height);
    }

    public static CarView carProvider(String carType, double positionX, double positionY, double size, double speed){
        return new CarView(carType, positionX, positionY, size, speed);
    }

    public static SnakeView snakeProvider(double positionX, double positionY, double size, double speed){
        return new SnakeView(positionX, positionY, size, speed);
    }

    public static LongTruckView longTruckProvider(String longTruckType, double positionX, double positionY, double size, double speed){
        return new LongTruckView(longTruckType, positionX, positionY, size, speed);
    }

    public static ShortTruckView shortTruckProvider(String shortTruckType, double positionX, double positionY, double size, double speed){
        return new ShortTruckView(shortTruckType, positionX, positionY, size, speed);
    }

    public static CrocodileBodyView crocodileBodyProvider(double positionX, double positionY, double size, double speed){
        return new CrocodileBodyView(positionX, positionY, size, speed);
    }

    public static CrocodileHeadView crocodileHeadProvider(double positionX, double positionY, double size, double speed){
        return new CrocodileHeadView(positionX, positionY, size, speed);
    }

    public static LogView logProvider(String type, double positionX, double positionY, double size, double speed){
        return new LogView(type, positionX, positionY, size, speed);
    }

    public static DryTurtleView dryTurtleProvider(double positionX, double positionY, double size, double speed){
        return new DryTurtleView(positionX, positionY, size, speed);
    }

    public static WetTurtleView wetTurtleProvider(double positionX, double positionY, double size, double speed){
        return new WetTurtleView(positionX, positionY, size, speed);
    }
}
