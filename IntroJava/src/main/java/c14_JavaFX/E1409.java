/* 
(Create four taichis) Write a program that places four taichis in a GridPane
with two rows and two columns, as shown in Figure 14.45b.
*/

package c14_JavaFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class E1409 extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10,10,10,10));
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(5);
        pane.setVgap(5);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                StackPane taichi = new StackPane(getCircle());
                getArc(taichi);
                pane.add(taichi, i, j);
            }
        }

        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setTitle("Chess Board");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }

    private static void getArc(StackPane pane) {
        double r = 100;
        for (int i = 0; i < 4; i++) { 
            Arc a = new Arc(150, 150, r, r, 30 + 90 * i, 30);
            a.setType(ArcType.ROUND);
            a.setFill(Color.BLACK);
            // have to put arc on a pane otherwise it's not centered
            pane.getChildren().addAll(new Pane(a));
        }
    }

    private static Circle getCircle() {
        Circle c = new Circle();
                c.setRadius(150);
                c.setStroke(Color.BLACK);
                c.setFill(Color.WHITE);
        return c;
    }

}
