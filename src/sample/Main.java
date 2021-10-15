package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("UofT Tinder!");
        Label label1 = new Label("Username:");
        Label label2 = new Label("Password:");
        TextField textField1 = new TextField ();
        TextField textField2 = new TextField ();
        Button btn = new Button("Create new account");
        Button btn1 = new Button("Sign In");

        VBox hb = new VBox();
        BorderPane bp = new BorderPane();
        hb.getChildren().addAll(label1, textField1);
        hb.getChildren().addAll(label2, textField2);
        hb.getChildren().add(btn);
        hb.getChildren().add(btn1);

        hb.setSpacing(20);
        bp.setCenter(hb);
        bp.setCenterShape(true);
        primaryStage.centerOnScreen();
        primaryStage.setScene(new Scene(bp, 600, 800));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
