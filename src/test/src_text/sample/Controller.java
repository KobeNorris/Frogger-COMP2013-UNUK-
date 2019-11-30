package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sample.*;

public class Controller {
    @FXML private TextField nameInputField;

    @FXML
    public void insertRank(){
        FileProcesscer i = new FileProcesscer(10);
        System.out.println(nameInputField.getText());
        try{
            i.readFile("src/sample/rank.txt");
            i.insertElement(nameInputField.getText().trim(), 30);
            i.writeFile("src/sample/rank.txt");
//            i.showLists();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
