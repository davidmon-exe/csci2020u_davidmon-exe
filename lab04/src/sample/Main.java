package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.awt.*;
import static javafx.scene.text.Font.font;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Lab 4 Solution");
        primaryStage.setScene(new Scene(root, 600, 400));

        // Creating Layout gridpane
        BorderPane myBorder = new BorderPane();
        myBorder.setAlignment(Pos.CENTER);
        myBorder.setHgap(10);
        myBorder.setVgap(10);
        myBorder.setPadding(new Insets(25, 25, 25, 25));

        // Creating myScene with custom layout
        Scene myScene = new Scene(myBorder, 600, 400);
        primaryStage.setScene(myScene);

        // Create login UI controls
        // ---Title Welcome
        Text sceneTitle = new Text("Welcome");
        sceneTitle.setFont(font("Tahoma", FontWeight.NORMAL, 20));
        // ---Labels
        Label lbUserName = new Label("Username:");
        Label lbPassword = new Label("Password:");
        Label lbFullName = new Label("Full Name:");
        Label lbEmail = new Label("E-Mail:");
        Label lbPhoneNum = new Label("Phone #:");
        Label lbDateOfB = new Label("Date of Birth:");
        // ---Inputs
        TextField txUserName = new TextField();
        PasswordField psPassword = new PasswordField();
        TextField txFullName = new TextField();
        TextField txEmail = new TextField();
        TextField txPhoneNum = new TextField();
        TextField txDateOfB = new TextField();

        // ---Button
        Button btn = new Button("Register");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);

        // ---Link
        final Text actionTarget = new Text();

        // --- Add components
        myBorder.add(sceneTitle, 0, 0, 2, 1);
        myBorder.add(lbUserName, 0, 1);
        myBorder.add(txUserName, 1, 1);
        myBorder.add(lbPassword, 0, 2);
        myBorder.add(psPassword, 1, 2);
        myBorder.add(lbFullName, 0, 3);
        myBorder.add(txFullName, 1, 3);
        myBorder.add(lbEmail, 0, 4);
        myBorder.add(txEmail, 1, 4);
        myBorder.add(lbPhoneNum, 0, 5);
        myBorder.add(txPhoneNum, 1, 5);
        myBorder.add(lbDateOfB, 0, 6);
        myBorder.add(txDateOfB, 1, 6);
        myBorder.add(hbBtn, 1, 7);
        myBorder.add(actionTarget, 1, 8);

        // Setting the btn event
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String userName = txUserName.getText();
                if (userName == null) {
                    actionTarget.setFill(Color.FIREBRICK);
                    actionTarget.setText("Please give a username!");
                }
            }
        });
        primaryStage.setScene(myScene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
