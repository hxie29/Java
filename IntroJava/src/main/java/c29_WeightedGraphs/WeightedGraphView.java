/*(Display weighted graphs) Revise GraphView in Listing 28.6 to display a
weighted graph. Write a program that displays the graph in Figure 29.1 as
shown in Figure 29.24. (Instructors may ask students to expand this program
by adding new cities with appropriate edges into the graph).*/
package c29_WeightedGraphs;

import c28_Graphs.Displayable;
import c28_Graphs.Graph;
import c28_Graphs.UnweightedGraph;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.util.List;

public class WeightedGraphView extends BorderPane {
    private final WeightedGraph<? extends Displayable> graph;
    private final Group group = new Group();

    public WeightedGraphView(WeightedGraph<? extends Displayable> graph) {
        this.graph = graph;
        Pane graphPane = new Pane();
        graphPane.getChildren().add(group);
        this.setCenter(graphPane);
        repaintGraph();
    }

    public void repaintGraph() {
        group.getChildren().clear();
        List<? extends Displayable> vertices = graph.getVertices();
        for (int i = 0; i < graph.getSize(); i++) {
            double x = vertices.get(i).getX();
            double y = vertices.get(i).getY();

            group.getChildren().add(new Circle(x, y, 10));
            group.getChildren().add(new Text(x-8, y-18, vertices.get(i).getName()));
        }

        for (int i = 0; i < graph.getSize(); i++) {
            List<Integer> neighbors = graph.getNeighbors(i);
            double x1 = graph.getVertex(i).getX();
            double y1 = graph.getVertex(i).getY();
            for (Integer n: neighbors) {
                double x2 = graph.getVertex(n).getX();
                double y2 = graph.getVertex(n).getY();
                group.getChildren().add(new Line(x1, y1, x2, y2));
                try {
                    group.getChildren().add(new Text(x1 / 2 + x2 / 2 -5, y1 / 2 + y2 / 2-10, graph.getWeight(i, n) + ""));
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
