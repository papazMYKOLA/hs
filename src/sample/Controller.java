package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class Controller extends Main{
    Scene stage = new Scene(createContent(4));
    public void  startPress (){

        Stage primaryStage = new Stage();
        primaryStage.setScene(stage);
        primaryStage.show();

    }

    @FXML
    ChoiceBox player=new ChoiceBox();
    @FXML
    ChoiceBox bot=new ChoiceBox();
    @FXML
    ChoiceBox rule=new ChoiceBox();
    @FXML
    Button start;

    @FXML
    public void initialize() {

        player.getItems().add("1");
        player.getItems().add("2");
        player.getItems().add("3");
        player.getItems().add("4");
        player.getItems().add("5");
        player.getItems().add("6");
        player.setValue("2");

    }
}
