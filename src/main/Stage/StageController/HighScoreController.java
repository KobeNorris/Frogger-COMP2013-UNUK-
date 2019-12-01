package main.Stage.StageController;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import main.util.FileProcesscer;
import main.util.SceneSwitcher;


import java.io.IOException;
import java.net.URL;

public class HighScoreController {
    @FXML
    public Label name1, score1, name2, score2, name3, score3, name4, score4, name5, score5;

    @FXML
    protected void initialize(){
        updateLabel();
    }

    @FXML
    public void updateLabel(){
        String[] nameList;
        int[] scoreList;

        try {
            FileProcesscer i = new FileProcesscer(5);
            i.readFile("src/resource/highScoreFile/rank.txt");
            nameList = i.getName();
            scoreList = i.getScore();
            name1.setText(nameList[0]);
            name2.setText(nameList[1]);
            name3.setText(nameList[2]);
            name4.setText(nameList[3]);
            name5.setText(nameList[4]);
            if(scoreList[0] == -1)
                score1.setText("EMPTY");
            else
                score1.setText(scoreList[0] + "");
            if(scoreList[1] == -1)
                score2.setText("EMPTY");
            else
                score2.setText(scoreList[1] + "");
            if(scoreList[2] == -1)
                score3.setText("EMPTY");
            else
                score3.setText(scoreList[2] + "");
            if(scoreList[3] == -1)
                score4.setText("EMPTY");
            else
                score4.setText(scoreList[3] + "");
            if(scoreList[4] == -1)
                score5.setText("EMPTY");
            else
                score5.setText(scoreList[4] + "");
        }catch(Exception e){
            System.out.println(e + "Here");
        }
    }

    @FXML
    private void jumpToMenu()throws IOException {
        SceneSwitcher.jumpToMenu();
    }
}
