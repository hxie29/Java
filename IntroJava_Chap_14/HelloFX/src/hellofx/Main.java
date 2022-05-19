package hellofx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Circle circle = new Circle();
        circle.setCenterX(100);
        circle.setCenterY(100);
        circle.setRadius(50);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.RED);
        StackPane pane = new StackPane(circle);
        Scene scene = new Scene(pane, 400, 250);
        primaryStage.setTitle("Show circle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}