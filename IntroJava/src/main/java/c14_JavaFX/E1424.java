/* 
(Geometry: Inside a polygon?) Write a program that prompts the user to enter
the coordinates of five points from the command line. The first four points form a
polygon, and the program displays the polygon and a text that indicates whether
the fifth point is inside the polygon, as shown in Figure 14.51a. (Hint: Use the
Node’s contains method to test whether a point is inside a node.)
}
*/

package c14_JavaFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;

import java.util.Scanner;


public class E1424 extends Application {
    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10,10,10,10));

        Scanner input = new Scanner(System.in);
        Double[] polygonPoints = new Double[8];
        Double[] point = new Double[2];
        System.out.println("Enter coordinates of five points: ");
        for (int i = 0; i < polygonPoints.length + 2; i++) {
            if (i < polygonPoints.length) polygonPoints[i] = input.nextDouble();
            else point[i - polygonPoints.length] = input.nextDouble();
        }
        input.close();

        Polygon polygon = new Polygon();
        polygon.getPoints().addAll(polygonPoints);
        polygon.setFill(Color.WHITE);
        polygon.setStroke(Color.BLACK);

        Circle c1 = new Circle(point[0], point[1], 15);
        c1.setStroke(Color.BLACK);
        c1.setFill(Color.WHITE);
        String t = "The point is" + ((polygon.contains(point[0], point[1])) ? " " : "not ") + "inside the polygon";
        Text text = new Text(600,600,t);
        text.setFill(Color.BLACK);

        pane.getChildren().addAll(polygon, c1, text);

        Scene scene = new Scene(pane, 1600, 1300);
        primaryStage.setTitle("Show polygon and a point");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }

}
