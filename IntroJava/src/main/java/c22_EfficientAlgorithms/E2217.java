/* (Closest-pair animation) Write a program that enables the user to add/remove
points by clicking the left/right mouse button and displays a line that connects
the pair of nearest points, as shown in Figure 22.4.
*/
package c22_EfficientAlgorithms;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class E2217 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        ClosestPairPane pairPane = new ClosestPairPane();

        HBox pane = new HBox(10);
        VBox leftPane = new VBox(10);
        leftPane.setMaxHeight(100);
        leftPane.setStyle("-fx-border-color: black");
        leftPane.getChildren().add(new Label("INSTRUCTION"));
        leftPane.getChildren().add(new Label("Add: left click"));
        leftPane.getChildren().add(new Label("Remove: right click"));
        pane.getChildren().addAll(leftPane, pairPane);

        // coordinates is dislocated, how to solve?
        pane.setOnMousePressed(e -> {
            if (e.isPrimaryButtonDown()) {
                double width = leftPane.getWidth();
                pairPane.addPoint(e.getX() - width, e.getY());
            }
            else
                pairPane.removePoint(e.getX(), e.getY());
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
