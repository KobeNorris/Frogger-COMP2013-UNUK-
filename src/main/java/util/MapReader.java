package util;

import com.end.EndView;
import controller.gameController.GameController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MapReader {

    public static void generateMap(String filePath, GameController controller)throws IOException {
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String gameMode = bufferedReader.readLine();
        String elementInfo = bufferedReader.readLine();
        String[] parameter;
        while(elementInfo != null) {
            parameter = elementInfo.split(" ");
            switch(parameter[0]){
                case "log":
                    if(parameter[1].equals("short"))
                        controller.add(ElementFactory.logProvider(parameter[1], Double.valueOf(parameter[2]), Double.valueOf(parameter[3]),140, Double.valueOf(parameter[4])));
                    else if(parameter[1].equals("middle"))
                        controller.add(ElementFactory.logProvider(parameter[1], Double.valueOf(parameter[2]), Double.valueOf(parameter[3]),170, Double.valueOf(parameter[4])));
                    else if(parameter[1].equals("long"))
                        controller.add(ElementFactory.logProvider(parameter[1], Double.valueOf(parameter[2]), Double.valueOf(parameter[3]),280, Double.valueOf(parameter[4])));
                    break;
                case "crocodileBody":
                    controller.add(ElementFactory.crocodileBodyProvider(Double.valueOf(parameter[1]), Double.valueOf(parameter[2]),90, Double.valueOf(parameter[3])));
                    break;
                case "crocodileHead":
                    controller.add(ElementFactory.crocodileHeadProvider(Double.valueOf(parameter[1]), Double.valueOf(parameter[2]),60, Double.valueOf(parameter[3])));
                    break;
                case "wetTurtle":
                    controller.add(ElementFactory.wetTurtleProvider(Double.valueOf(parameter[1]), Double.valueOf(parameter[2]),130, Double.valueOf(parameter[3])));
                    break;
                case "dryTurtle":
                    controller.add(ElementFactory.dryTurtleProvider(Double.valueOf(parameter[1]), Double.valueOf(parameter[2]),130, Double.valueOf(parameter[3])));
                    break;
                case "car":
                    controller.add(ElementFactory.carProvider(Double.valueOf(parameter[1]), Double.valueOf(parameter[2]),50, Double.valueOf(parameter[3])));
                    break;
                case "shortTruck":
                    controller.add(ElementFactory.shortTruckProvider(Double.valueOf(parameter[1]), Double.valueOf(parameter[2]),120, Double.valueOf(parameter[3])));
                    break;
                case "longTruck":
                    controller.add(ElementFactory.longTruckProvider(Double.valueOf(parameter[1]), Double.valueOf(parameter[2]),200, Double.valueOf(parameter[3])));
                    break;
                default:
            }
            elementInfo = bufferedReader.readLine();
        }
        controller.endList = new EndView[5];
        controller.endList[0] = ElementFactory.endProvider(14,97, 63, 63);
        controller.endList[1] = ElementFactory.endProvider(142,97, 63, 63);
        controller.endList[2] = ElementFactory.endProvider(271,97, 63, 63);
        controller.endList[3] = ElementFactory.endProvider(399,97, 63, 63);
        controller.endList[4] = ElementFactory.endProvider(528,97, 63, 63);
        controller.add(controller.endList[0]);
        controller.add(controller.endList[1]);
        controller.add(controller.endList[2]);
        controller.add(controller.endList[3]);
        controller.add(controller.endList[4]);

        controller.frogger = ElementFactory.froggerProvider();
        controller.frogger.setGameMode(gameMode);
        controller.frogger.changeEnd();
        controller.add(controller.frogger);

        controller.initInfo(gameMode);
    }
}
