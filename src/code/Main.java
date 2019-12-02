package code;

import code.stage.gameStages.GameStage;
import code.util.FileProcesscer;
import code.util.SceneSwitcher;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application{
    private static AnimationTimer timer;
    private static Stage presentStage;
    private static GameStage background;
    private static String presentMode;
    public static int points = 0, diffficulty = 1;
    public static String getPresentMode() {return Main.presentMode;}
    public static void setPresentMode(String targetMode){presentMode = targetMode;}
    public static Stage getPresentStage(){return presentStage;}
    public static void setBackground(GameStage targetStage){background = targetStage;}

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Main.presentStage = primaryStage;
        SceneSwitcher.jumpToMenu();
    }

    public static void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long timer) {
                if (background.frogger.checkScore())
                    background.updateScore(background.frogger.getPoints());
                if(background.frogger.checkLife())
                    background.updateLife(background.frogger.getLife());
                if (background.frogger.getStop()){
                    background.frogger.resetToStart();
                    background.stopGame();
                    stop();
                    try{
                        FileProcesscer i = new FileProcesscer(5);
                        i.readFile("src/resource/highScoreFile/rank.txt");
                        points = background.frogger.getPoints();
                        if(i.checkInsertable(background.frogger.getPoints())){
                            SceneSwitcher.jumpToInputName();
                        }else{
                            SceneSwitcher.jumpToHighScore();
                        }
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    background.frogger.resetPoints();
                }
            }
        };
    }

    public static void start() {
        createTimer();
        timer.start();
    }
}
