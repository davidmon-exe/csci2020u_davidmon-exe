package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("registration.fxml"));
        primaryStage.setTitle("Lab 4  -  FXML");
        primaryStage.setScene(new Scene(root, 775, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
