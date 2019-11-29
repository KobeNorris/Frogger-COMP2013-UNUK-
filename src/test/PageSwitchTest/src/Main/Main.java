package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    private static Stage presentStage;
    private static Scene presentScene;
    public static Stage getPresentStage(){return presentStage;}
    public static void setPresentStage(Stage targetStage){
        presentStage = targetStage;
    }

    @Override
    public void start(Stage primaryStage) throws IOException{
        Main.presentStage = primaryStage;
        presentScene = new Scene(loadFXML("../StageView/MenuView.fxml"), 600, 800);
        presentStage.setScene(presentScene);
        presentStage.show();
    }

    public static Parent loadFXML(String fxml) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
