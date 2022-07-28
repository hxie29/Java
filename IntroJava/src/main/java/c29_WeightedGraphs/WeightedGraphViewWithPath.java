/*(Display weighted graphs) Revise GraphView in Listing 28.6 to display a
weighted graph. Write a program that displays the graph in Figure 29.1 as
shown in Figure 29.24. (Instructors may ask students to expand this program
by adding new cities with appropriate edges into the graph).*/
package c29_WeightedGraphs;

import c28_Graphs.Displayable;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.util.List;

public class WeightedGraphViewWithPath extends BorderPane {
    private final WeightedGraph<? extends Displayable> graph;
    private WeightedGraph<? extends Displayable>.ShortestPathTree tree;
    private final Group group = new Group();
    private final Group pathGroup = new Group();

    public WeightedGraphViewWithPath(WeightedGraph<? extends Displayable> graph) {
        this.graph = graph;
        Pane graphPane = new Pane();
        graphPane.getChildren().addAll(group, pathGroup);
        this.setCenter(graphPane);
        repaintGraph();
    }

    public void repaintGraph() {
        group.getChildren().clear();
        pathGroup.getChildren().clear();
        List<? extends Displayable> vertices = graph.getVertices();
        for (int i = 0; i < graph.getSize(); i++) {
            double x = vertices.get(i).getX();
            double y = vertices.get(i).getY();

            group.getChildren().add(new Circle(x, y, 16));
            group.getChildren().add(new Text(x-8, y-18, vertices.get(i).getName() + " (" + i + ")"));
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

    public boolean paintPath(int start, int end) {
        if (start > -1 && end > -1) {
            tree = graph.getShortestPath(end);
            pathGroup.getChildren().clear();
            List<? extends Displayable> treePath= tree.getPath(start);
            double lastX = 0, lastY = 0;
            for (int i = 0; i < treePath.size(); i++) {
                double x = treePath.get(i).getX();
                double y = treePath.get(i).getY();
                if (i > 0) {
                    Line path = new Line(lastX, lastY, x, y);
                    path.setStroke(Color.RED);
                    path.setStrokeWidth(5);
                    pathGroup.getChildren().add(path);
                }
                lastX = x;
                lastY = y;
            }
            return true;
        }
        return false;
    }

    public boolean paintPath(String startName, String endName) {
        return paintPath(getVertexIndex(startName), getVertexIndex(endName));
    }

    private int getVertexIndex(String name) {
        List<? extends Displayable> vertices = graph.getVertices();
        for (int i = 0; i < vertices.size(); i++) {
            if (name.equalsIgnoreCase(vertices.get(i).getName()))
                return i;
        }
        return -1;
    }
}
