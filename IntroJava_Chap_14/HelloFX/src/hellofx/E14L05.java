package hellofx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class E14L05 extends Application {
    @Override
    public void start(Stage primaryStage) {
        Circle circle = new Circle();
        StackPane pane = new StackPane(circle);
        circle.centerXProperty().bind(pane.widthProperty().divide(2));
        circle.centerYProperty().bind(pane.heightProperty().divide(2));
        circle.setRadius(50);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);

        Scene scene = new Scene(pane, 200, 250);
        primaryStage.setTitle("Show circle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }    

    public static void main(String[] args) {
        Application.launch(args);
    }
}
