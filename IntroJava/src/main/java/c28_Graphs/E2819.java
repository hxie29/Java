/*(Display a DFS/BFS tree in a graph) Modify GraphView in Listing 28.6 to add
a new data field tree with a setter method. The edges in the tree are displayed
in red. Write a program that displays the graph in Figure 28.1 and the DFS/BFS
tree starting from a specified city, as shown in Figures 28.13 and 28.16. If a city
not in the map is entered, the program displays an error message in the label.*/
package c28_Graphs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class E2819 extends Application {
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
                {0, 1}, {0, 3}, {0, 5}, {1, 0}, {1, 2}, {1, 3},
                {2, 1}, {2, 3}, {2, 4}, {2, 10},
                {3, 0}, {3, 1}, {3, 2}, {3, 4}, {3, 5},
                {4, 2}, {4, 3}, {4, 5}, {4, 7}, {4, 8}, {4, 10},
                {5, 0}, {5, 3}, {5, 4}, {5, 6}, {5, 7},
                {6, 5}, {6, 7}, {7, 4}, {7, 5}, {7, 6}, {7, 8},
                {8, 4}, {8, 7}, {8, 9}, {8, 10}, {8, 11},
                {9, 8}, {9, 11}, {10, 2}, {10, 4}, {10, 8}, {10, 11},
                {11, 8}, {11, 9}, {11, 10}
        };

        Graph<City> graph = new UnweightedGraph<>(vertices, edges);
        Scene scene = new Scene(new GraphViewWithTree(graph), 750, 800);
        primaryStage.setTitle("DisplayUSMap"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args){Application.launch(args);}
}
