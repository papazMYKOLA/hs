package sample;

import javafx.fxml.FXML;

import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class Controller extends Main{
        int players;
        int bots;
        int sum;

    public void  startPress (){
        players = Integer.parseInt(player.getValue().toString());
        bots = Integer.parseInt(bot.getValue().toString());
        sum = players + bots;
        if(sum==2 || sum==3 || sum==4 || sum==6) {
            Stage primaryStage = new Stage();
            primaryStage.setScene(new Scene(createContent(sum)));
            primaryStage.show();
        }
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
        bot.getItems().add("0");
        bot.getItems().add("1");
        bot.getItems().add("2");
        bot.getItems().add("3");
        bot.getItems().add("4");
        bot.getItems().add("5");
        player.getItems().add("1");
        player.getItems().add("2");
        player.getItems().add("3");
        player.getItems().add("4");
        player.getItems().add("5");
        player.getItems().add("6");
        player.setValue("2");
        bot.setValue("0");
    }


}
