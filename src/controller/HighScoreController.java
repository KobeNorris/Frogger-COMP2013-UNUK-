package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import util.FileProcessor;
import util.SceneSwitcher;


import java.io.IOException;

/**
 * This file is a controller for the high score page, it will display the 5 most highest score to the player.
 */
public class HighScoreController {
    @FXML
    public Label name1, score1, name2, score2, name3, score3, name4, score4, name5, score5, name6, score6, name7, score7, name8, score8, name9, score9, name10, score10;

    /**
     * Launch the data before user access the page
     */
    @FXML
    protected void initialize(){
        updateLabel();
    }

    /**
     * This function will call the file processor and allocate all data of present high score properly
     * into the FXML file.
     */
    @FXML
    public void updateLabel(){
        String[] nameList;
        int[] scoreList;

        try {
            FileProcessor i = new FileProcessor(10);
            i.readFile("resources/highScoreFile/rank.txt");
            nameList = i.getName();
            scoreList = i.getScore();
            name1.setText(nameList[0]);
            name2.setText(nameList[1]);
            name3.setText(nameList[2]);
            name4.setText(nameList[3]);
            name5.setText(nameList[4]);
            name6.setText(nameList[5]);
            name7.setText(nameList[6]);
            name8.setText(nameList[7]);
            name9.setText(nameList[8]);
            name10.setText(nameList[9]);
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
            if(scoreList[5] == -1)
                score6.setText("EMPTY");
            else
                score6.setText(scoreList[5] + "");
            if(scoreList[6] == -1)
                score7.setText("EMPTY");
            else
                score7.setText(scoreList[6] + "");
            if(scoreList[7] == -1)
                score8.setText("EMPTY");
            else
                score8.setText(scoreList[7] + "");
            if(scoreList[8] == -1)
                score9.setText("EMPTY");
            else
                score9.setText(scoreList[8] + "");
            if(scoreList[9] == -1)
                score10.setText("EMPTY");
            else
                score10.setText(scoreList[9] + "");
        }catch(Exception e){
            System.out.println(e + "Here");
        }
    }

    /**
     * Jumps from present stage to the start menu
     *
     * @throws IOException Invalid FXML file
     */
    @FXML
    private void jumpToMenu()throws IOException {
        SceneSwitcher.jumpToMenu();
    }
}
