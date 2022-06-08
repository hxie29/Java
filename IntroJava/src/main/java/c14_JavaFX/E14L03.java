package c14_JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;

public class E14L03 extends Application {
    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane(new Button("OK"));
        Scene scene = new Scene(pane, 200, 250);
        primaryStage.setTitle("MyJavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }    

    public static void main(String[] args) {
        Application.launch(args);
    }
}
