package chap15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class E15L11 extends Application {
    private Circle c = new Circle(60);
    private Rectangle r = new Rectangle(120,120);
    private StackPane pane = new StackPane();

    @Override
    public void start(Stage primaryStage) {
        c.setFill(Color.RED);
        r.setFill(Color.WHITE);
        r.setStroke(Color.BLACK);
        pane.getChildren().addAll(r,c);

        pane.widthProperty().addListener(ov -> resize());
        pane.heightProperty().addListener(ov -> resize());

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Resizeable Circle Rectangle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void resize() {
        double length = Math.min(pane.getWidth(), pane.getHeight());
        c.setRadius(length / 2 - 15);
        r.setWidth(length - 30);
        r.setHeight(length - 30);
    }

    public static void main(String[] args ){
        launch(args);
    }
}