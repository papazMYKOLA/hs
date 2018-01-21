package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller extends Main{
    Scene stage = new Scene(createContent());
    public void  startPress (){

        Stage primaryStage = new Stage();
        primaryStage.setScene(stage);
        primaryStage.show();

    }
}
