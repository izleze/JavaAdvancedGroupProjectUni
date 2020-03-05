package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader
                .load(getClass().getResource("sample.fxml"));

//        root.lookup("monstersPlayer1").getId();
//        root.lookup("monstersPlayer2").getId();

        int height = 1000;
        int width = 1500;

        primaryStage.setMinHeight(height);
        primaryStage.setMinWidth(width);

        primaryStage.setMaxHeight(height);
        primaryStage.setMaxWidth(width);

        primaryStage.setTitle("Pharaohs Game");
        primaryStage.setScene(
                new Scene(root, primaryStage.getMinWidth(), primaryStage.getMinHeight()));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
