package c14_JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class E14L15 extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Line l1 = new Line(10, 10, 10, 10);
        l1.setStrokeWidth(5);
        l1.endXProperty().bind(pane.widthProperty().subtract(10));
        l1.endYProperty().bind(pane.heightProperty().subtract(10));
        
        Line l2 = new Line(10, 10, 10, 10);
        l2.startXProperty().bind(pane.widthProperty().subtract(10));
        l2.endYProperty().bind(pane.heightProperty().subtract(10));

        pane.getChildren().addAll(l1, l2);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Show Line cross");
        primaryStage.setScene(scene);
        primaryStage.show();
    }   
    

    public static void main(String[] args) {
        Application.launch(args);
    }
}
