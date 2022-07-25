/*(Display a DFS/BFS tree in a graph) Modify GraphView in Listing 28.6 to add
a new data field tree with a setter method. The edges in the tree are displayed
in red. Write a program that displays the graph in Figure 28.1 and the DFS/BFS
tree starting from a specified city, as shown in Figures 28.13 and 28.16. If a city
not in the map is entered, the program displays an error message in the label.*/
package c28_Graphs;

import javafx.geometry.Pos;
import javafx.scene.Group;
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

public class GraphViewWithTree extends BorderPane {
    private final Graph<? extends Displayable> graph;
    private UnweightedGraph<? extends Displayable>.SearchTree tree;
    private final Group group = new Group();

    public GraphViewWithTree(Graph<? extends Displayable> graph) {
        this.graph = graph;
        this.setCenter(group);
        repaintGraph();
        TextField tfInput = new TextField();
        Text title = new Text(" ");
        tfInput.setAlignment(Pos.BASELINE_RIGHT);
        Label lbInput = new Label("Enter a city: ", tfInput);
        lbInput.setContentDisplay(ContentDisplay.RIGHT);
        this.setBottom(lbInput);
        this.setTop(title);
        BorderPane.setAlignment(lbInput, Pos.CENTER);
        BorderPane.setAlignment(title, Pos.CENTER);
        tfInput.setOnAction(e -> {
            boolean found = false;
            for (int i = 0; i < graph.getSize(); i++) {
                if (tfInput.getText().equals(graph.getVertex(i).getName())) {
                    setTree(i, true);
                    found = true;
                    title.setText("Tree found");
                    break;
                }
            }
            if (!found)
                title.setText("Error: input is not in the graph");
        });
    }

    public void setTree(int index, boolean isDFS) {
        if (isDFS) this.tree = graph.dfs(index);
        else this.tree = graph.bfs(index);
        paintTree();
    }

    public void repaintGraph() {
        group.getChildren().clear();
        List<? extends Displayable> vertices = graph.getVertices();
        for (int i = 0; i < graph.getSize(); i++) {
            double x = vertices.get(i).getX();
            double y = vertices.get(i).getY();

            group.getChildren().add(new Circle(x, y, 16));
            group.getChildren().add(new Text(x-8, y-18, vertices.get(i).getName()));
        }

        for (int i = 0; i < graph.getSize(); i++) {
            List<Integer> neighbors = graph.getNeighbors(i);
            for (Integer n: neighbors)
                group.getChildren().add(new Line(graph.getVertex(i).getX(), graph.getVertex(i).getY(),
                        graph.getVertex(n).getX(), graph.getVertex(n).getY()));
        }
    }

    private void paintTree() {
        List<? extends Displayable> vertices = graph.getVertices();
        List<Integer> searchOrder = tree.getSearchOrder();
        double lastX = 0, lastY = 0;
        for (int i = 0; i < searchOrder.size(); i++) {
            int index = searchOrder.get(i);
            double x = vertices.get(index).getX();
            double y = vertices.get(index).getY();
            if (i > 0) {
                Line path = new Line(lastX, lastY, x, y);
                path.setStroke(Color.RED);
                path.setStrokeWidth(5);
                group.getChildren().add(path);
            }
            lastX = x;
            lastY = y;
        }
    }
}
