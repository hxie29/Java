/*(Display a graph) Write a program that reads a graph from a file and displays
it. The first line in the file contains a number that indicates the number of vertices
(n). The vertices are labeled 0, 1, . . . , n−1. Each subsequent line, with the
format u x y v1 v2 ..., describes the position of u at (x, y) and edges (u,
v1), (u, v2), and so on. Figure 28.24a gives an example of the file for their corresponding
graph. Your program prompts the user to enter the name of the file,
reads data from the file, and displays the graph on a pane using GraphView, as
shown in Figure 28.24b.*/
package c28_Graphs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E2820 extends Application {
    private static Graph<Vertex> graph;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(new GraphView(graph), 750, 450);
        primaryStage.setTitle("Read and display graph from a file"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a file name: ");
        File file = new File(input.nextLine());
        try {
            graph = readGraph(file);
            Application.launch(args);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static Graph<Vertex> readGraph(File file) throws IOException {
        try (Scanner in = new Scanner(file)) {
            List<Vertex> vertices = new ArrayList<>();
            List<Edge> edges = new ArrayList<>();
            while (in.hasNextLine()) {
                String line = in.nextLine();
                String[] numbers = line.split("[\\s+]");
                if (numbers.length > 3) {
                    vertices.add(new Vertex(numbers[0], Double.parseDouble(numbers[1]), Double.parseDouble(numbers[2])));
                    for (int i = 3; i < numbers.length; i++)
                        edges.add(new Edge(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[i])));
                }
            }
            return new UnweightedGraph<>(vertices, edges);
        }
    }


    public static class Vertex implements Displayable {
        double x, y;
        String name;

        public Vertex(String name, double x, double y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }

        @Override
        public double getX() {
            return x;
        }

        @Override
        public double getY() {
            return y;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}
