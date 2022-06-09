/* 
(Geometry: Inside a polygon?) Write a program that prompts the user to enter
the coordinates of five points from the command line. The first four points form a
polygon, and the program displays the polygon and a text that indicates whether
the fifth point is inside the polygon, as shown in Figure 14.51a. (Hint: Use the
Node’s contains method to test whether a point is inside a node.)
}
*/

package c14_JavaFX;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;

public class E1425 extends Application {
    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10,10,10,10));
        Circle c1 = new Circle(500);
        c1.setStroke(Color.BLACK);
        c1.setFill(Color.WHITE);

        double[] angle = new double[5];
        for (int i = 0; i < 5; i++) {
            angle[i] = Math.random() * 2 * Math.PI;
        }
        Arrays.sort(angle);

        ArrayList<Double> list = new ArrayList<>();
        for (double v : angle) {
            list.add(Math.cos(v) * c1.getRadius());
            list.add(Math.sin(v) * c1.getRadius());
        }

        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(list);
        polygon.setFill(Color.WHITE);
        polygon.setStroke(Color.BLACK);

        //Use group so the center is always aligned
        Group group = new Group(c1, polygon);

        pane.getChildren().addAll(group);

        Scene scene = new Scene(pane, 1600, 1300);
        primaryStage.setTitle("Show a circle and a polygon");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }

}
