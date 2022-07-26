/*(Remove a circle) Modify Listing 28.10, ConnectedCircles.java, to enable the
user to remove a circle when the mouse is clicked inside the circle.*/
package c28_Graphs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class E2824 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(new CirclePane(), 800,800);
        primaryStage.setTitle("Connected circles"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
}
