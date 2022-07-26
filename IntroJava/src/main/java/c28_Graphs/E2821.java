/*(Display sets of connected circles) Modify Listing 28.10, ConnectedCircles.
java to display sets of connected circles in different colors. That is, if two
circles are connected, they are displayed using the same color; otherwise,
they are not in same color, as shown in Figure 28.25. (Hint: See Programming
Exercise 28.4.)*/
package c28_Graphs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class E2821 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(new CirclePaneDifferentColor(), 800,800);
        primaryStage.setTitle("Connected circles with different colors"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
}
