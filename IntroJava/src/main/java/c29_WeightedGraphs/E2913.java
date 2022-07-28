/*(Display shortest paths) Revise GraphView in Listing 28.6 to display a
weighted graph and a shortest path between the two specified cities, as shown
in Figure 29.25. You need to add a data field path in GraphView. If a path
is not null, the edges in the path are displayed in red. If a city not in the map is
entered, the program displays a text to alert the user.*/
package c29_WeightedGraphs;

import c28_Graphs.City;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class E2913 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        City[] vertices = {new City("Seattle", 75, 50),
                new City("San Francisco", 50, 210),
                new City("Los Angeles", 75, 275), new City("Denver", 275, 175),
                new City("Kansas City", 400, 245),
                new City("Chicago", 450, 100), new City("Boston", 700, 80),
                new City("New York", 675, 120), new City("Atlanta", 575, 295),
                new City("Miami", 600, 400), new City("Dallas", 408, 325),
                new City("Houston", 450, 360) };

        // Edge array for graph in Figure 28.1
        int[][] edges = {
                {0, 1, 807}, {0, 3, 1331}, {0, 5, 2097},
                {1, 0, 807}, {1, 2, 381}, {1, 3, 1267},
                {2, 1, 381}, {2, 3, 1015}, {2, 4, 1663}, {2, 10, 1435},
                {3, 0, 1331}, {3, 1, 1267}, {3, 2, 1015}, {3, 4, 599},
                {3, 5, 1003},
                {4, 2, 1663}, {4, 3, 599}, {4, 5, 533}, {4, 7, 1260},
                {4, 8, 864}, {4, 10, 496},
                {5, 0, 2097}, {5, 3, 1003}, {5, 4, 533},
                {5, 6, 983}, {5, 7, 787},
                {6, 5, 983}, {6, 7, 214},
                {7, 4, 1260}, {7, 5, 787}, {7, 6, 214}, {7, 8, 888},
                {8, 4, 864}, {8, 7, 888}, {8, 9, 661},
                {8, 10, 781}, {8, 11, 810},
                {9, 8, 661}, {9, 11, 1187},
                {10, 2, 1435}, {10, 4, 496}, {10, 8, 781}, {10, 11, 239},
                {11, 8, 810}, {11, 9, 1187}, {11, 10, 239}
        };

        WeightedGraph<City> graph = new WeightedGraph<>(vertices, edges);

        BorderPane pane = new BorderPane();
        WeightedGraphViewWithPath graphPane = new WeightedGraphViewWithPath(graph);
        pane.setCenter(graphPane);
        BorderPane.setAlignment(graphPane, Pos.CENTER);

        Text tStatus = new Text("Enter cities");
        pane.setTop(tStatus);
        BorderPane.setAlignment(tStatus, Pos.CENTER);

        HBox hbInput = new HBox(10);
        TextField tfStart = new TextField();
        TextField tfEnd = new TextField();
        Label lbStart = new Label("Starting city: ", tfStart);
        lbStart.setContentDisplay(ContentDisplay.RIGHT);
        Label lbEnd = new Label("Ending city: ", tfEnd);
        lbEnd.setContentDisplay(ContentDisplay.RIGHT);
        Button btFindPath = new Button("Display Shortest Path");
        hbInput.getChildren().addAll(lbStart, lbEnd, btFindPath);
        hbInput.setAlignment(Pos.CENTER);
        pane.setBottom(hbInput);
        BorderPane.setAlignment(hbInput, Pos.CENTER);

        btFindPath.setOnAction(e -> {
            if (graphPane.paintPath(tfStart.getText(), tfEnd.getText()))
                tStatus.setText("Shortest path displayed");
            else tStatus.setText("Cities entered not in the graph");
        });


        Scene scene = new Scene(pane, 750, 650);
        primaryStage.setTitle("DisplayUSMap"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args){Application.launch(args);}
}
