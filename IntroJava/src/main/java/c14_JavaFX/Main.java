package c14_JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
        Button ok = new Button("ok");
        StackPane pane = new StackPane(ok);
        ok.setStyle("-fx-border-color: blue; -fx-background-color: gray;");
        ok.setRotate(45);
        Scene scene = new Scene(pane, 200, 250);
        primaryStage.setTitle("Show circle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
