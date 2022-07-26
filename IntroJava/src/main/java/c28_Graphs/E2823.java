/*((Connected rectangles) Listing 28.10, ConnectedCircles.java, allows the user
to create circles and determine whether they are connected. Rewrite the program
for rectangles. The program lets the user create a rectangle by clicking a
mouse in a blank area that is not currently covered by a rectangle. As the rectangles
are added, the rectangles are repainted as filled if they are connected or
are unfilled otherwise, as shown in Figure 28.25b–c.*/
package c28_Graphs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class E2823 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(new RectanglePane(), 800,800);
        primaryStage.setTitle("Connected Rectangles"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
}
