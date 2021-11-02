package Phase1.Views;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 *
 */
public class LogInViewBuilder implements SceneBuilder{
    Scene scene;
    HBox hb1;
    Button bt1;
    Button bt2;
    BorderPane bp;
    VBox v;
    VBox v1;
    public LogInViewBuilder(){
        this.bp = new BorderPane();

    }


    /**
     * Creates the HBoxes necessary for the scene.
     */
    @Override
    public void addHBox() {
        this.hb1 = new HBox();
    }


    /** Maps each button to its corresponding eventhandler.
     * @param e A list of eventhandlers
     */

    @Override
    public void mapEventHandler(ArrayList<EventHandler> e) {
        Button btn = new Button("Create new account");
        Button btn1 = new Button("Log In");
        this.hb1.getChildren().add(btn);
        this.hb1.getChildren().add(btn1);

        if (!e.isEmpty()) {
            EventHandler t = e.get(0);
            EventHandler t1 = e.get(1);
            btn.setOnAction(t);
            btn1.setOnAction(t1);
        }

    }

    /**
     * Creates all the VBoxes necessary for the scene.
     */
    @Override
    public void addVBox() {
        System.out.println("Working");

        this.v = new VBox();
        this.v1 = new VBox();

    }

    @Override
    public void setMargin(Insets inset) {

    }


    /**
     * Adds textfield to the corresponding box.
     */
    @Override
    public void addTextField() {
        Label label1 = new Label("Username:");
        Label label2 = new Label("Password:");
        TextField textField1 = new TextField ();
        this.v.getChildren().addAll(label1,
                textField1);
        PasswordField textField2 = new PasswordField();
        this.v.getChildren().addAll(label2, textField2);
        this.v1.getChildren().add(this.v);
        this.v1.getChildren().add(this.hb1);

    }

    /**
     * Sets the spacing for each box.
     */
    @Override
    public void setSpacing() {

        v.setSpacing(20);
        hb1.setSpacing(50);
        v1.setSpacing(50);
    }

    /**
     * Sets the margin of the biggest box in the borderpane.
     */
    @Override
    public void setMargin() {
        this.bp.setCenter(v1);
        this.bp.setMargin(this.v1, new Insets(50, 50, 50, 50));

    }

    /** Set scene on the stage.
     * @param stage the mainstage where we display the scene.
     */
    @Override
    public void setScene(Stage stage) {
        this.scene = new Scene(this.bp, 450, 300);
        stage.setScene(this.scene);
    }

    @Override
    public void build(Stage s, ArrayList<EventHandler> e){
        this.addHBox();
        this.mapEventHandler(e);
        this.addVBox();
        this.addTextField();
        this.setSpacing();
        this.setMargin();
        this.setScene(s);


    }


}