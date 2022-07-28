/*(Dynamic graphs) Write a program that lets the users create a weighted graph
dynamically. The user can create a vertex by entering its name and location, as
shown in Figure 29.27. The user can also create an edge to connect two vertices.
To simplify the program, assume vertex names are the same as vertex indices.
You have to add the vertex indices 0, 1, . . . , and n, in this order. The user can
specify two vertices and let the program display their shortest path in red.*/
package c29_WeightedGraphs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class E2915 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(new DynamicGraphPane(), 750, 650);
        primaryStage.setTitle("DisplayUSMap"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args){Application.launch(args);}
}
