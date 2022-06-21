/*(Geometry: convex hull animation) Programming Exercise 22.11 finds a convex
hull for a set of points entered from the console. Write a program that enables
the user to add or remove points by clicking the left or right mouse button and
displays a convex hull, as shown in Figure 22.8c.*/
package c22_EfficientAlgorithms;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class E2213 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        ConvexHullPane hullPane = new ConvexHullPane();

        HBox pane = new HBox(10);
        VBox leftPane = new VBox(10);
        leftPane.setStyle("-fx-border-color: black");
        leftPane.getChildren().add(new Label("INSTRUCTION"));
        leftPane.getChildren().add(new Label("Add: left click"));
        leftPane.getChildren().add(new Label("Remove: right click"));
        pane.getChildren().addAll(leftPane, hullPane);

        // coordinates is dislocated, how to solve?
        pane.setOnMousePressed(e -> {
            if (e.isPrimaryButtonDown()) {
                double width = leftPane.getWidth();
                hullPane.addPoint(e.getX() - width, e.getY());
            }
            else
                hullPane.removePoint();
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
