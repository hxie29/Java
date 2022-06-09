package c14_JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class E14L19 extends Application {
    @Override
    public void start(Stage primaryStage) {
        

        Scene scene = new Scene(new MyPolygon(), 300,200);
        primaryStage.setTitle("Show Polygon");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
