package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        int height = 744;
        int width = 1144;

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
