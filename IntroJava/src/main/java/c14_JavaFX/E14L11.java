package c14_JavaFX;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

public class E14L11 extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(20, 20, 20, 20));
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(5);
        pane.setVgap(5);

        pane.add(new Label("First Name:"), 0, 0);
        pane.add(new TextField(), 1, 0);
        
        pane.add(new Label("Last Name:"), 0, 1);
        pane.add(new TextField(), 1, 1);

        pane.add(new Label("MI:"), 0, 2);
        pane.add(new TextField(), 1, 2);

        Button addName = new Button("Add Name");
        pane.add(addName, 1, 3);
        GridPane.setHalignment(addName, HPos.RIGHT);
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Show GridPane");
        primaryStage.setScene(scene);
        primaryStage.show();
    }    

    public static void main(String[] args) {
        Application.launch(args);
    }
}
