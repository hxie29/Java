/* (Geometry: noncrossed polygon) Write a program that enables the user to add
or remove points by clicking the left or right mouse button and displays a noncrossed
polygon that links all the points, as shown in Figure 22.11a. A polygon
is crossed if two or more sides intersect, as shown in Figure 22.11b. Use the
following algorithm to construct a polygon from a set of points:

Step 1: Given a set of points S, select the rightmost lowest
point p0 in the set S.
Step 2: Sort the points in S angularly along the x-axis
with p0 as the center. If there is a tie and two points have
the same angle, the one that is closer to p0 is considered
greater. The points in S are now sorted as p0, p1, p2, ...,
pn−1.
Step 3: The sorted points form a noncrossed polygon.
*/
package c22_EfficientAlgorithms;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class E2215 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        NCrossPolygonPane polygonPane = new NCrossPolygonPane();

        HBox pane = new HBox(10);
        VBox leftPane = new VBox(10);
        leftPane.setMaxHeight(100);
        leftPane.setStyle("-fx-border-color: black");
        leftPane.getChildren().add(new Label("INSTRUCTION"));
        leftPane.getChildren().add(new Label("Add: left click"));
        leftPane.getChildren().add(new Label("Remove: right click"));
        pane.getChildren().addAll(leftPane, polygonPane);

        // coordinates is dislocated, how to solve?
        pane.setOnMousePressed(e -> {
            if (e.isPrimaryButtonDown()) {
                double width = leftPane.getWidth();
                polygonPane.addPoint(e.getX() - width, e.getY());
            }
            else
                polygonPane.removePoint();
        });

        Scene scene = new Scene(pane, 1000, 800);
        stage.setScene(scene);
        stage.setTitle("Convex Hull display");
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }


}
