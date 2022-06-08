/* 
(Geometry: add and remove points) Write a program that lets the user click on
a pane to dynamically create and remove points (see Figure 15.30a). When the
user left-clicks the mouse (primary button), a point is created and displayed
at the mouse point. The user can remove a point by pointing to it and rightclicking
the mouse (secondary button).
 */
package chap15;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import javafx.scene.Node;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class E1517 extends Application {
    private Pane pane = new Pane();
    private ArrayList<Circle> circles = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        pane.setPadding(new Insets(10,10,10,10));

        VBox infoBox = new VBox();
        infoBox.setStyle("-fx-border-color: black");
        Label info1 = new Label("INSTRUCTION");
        Label info2 = new Label("Add: Left Click");
        Label info3 = new Label("Remove: Right Click");
        infoBox.getChildren().addAll(info1, info2, info3);
        pane.getChildren().add(infoBox);
        infoBox.setLayoutX(10);
        infoBox.setLayoutY(10);
        
        Scene scene = new Scene(pane, 500,500);
        primaryStage.setTitle("Show if mouse if in the circle");
        primaryStage.setScene(scene);
        primaryStage.show();

        pane.setOnMouseClicked(e -> {
            double x = e.getX();
            double y = e.getY();
            pane.getChildren().removeAll(circles);
            
            if (inside(circles, x, y) >= 0) {
                circles.remove(inside(circles,x,y));
                drawRectangle();
            }
            else {
                Circle c = new Circle(x, y, 10);
                c.setFill(Color.TRANSPARENT);
                c.setStroke(Color.BLACK);
                circles.add(c);
                drawRectangle();
            }
            pane.getChildren().addAll(circles);
        });
    }
    
    private int inside(ArrayList<Circle> list, double x, double y) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains(x, y)) return i;
        }
        return -1;
    }

    private void removeRec() {
        ObservableList<Node> list = pane.getChildren();
        for (Node c : list) {
            if (c instanceof Rectangle) list.remove(c);
        }
    }
    
    private void drawRectangle() {
        removeRec();
        Circle top = circles.get(0);
        Circle bottom = circles.get(0);
        Circle left = circles.get(0);
        Circle right = circles.get(0);
        double radius = circles.get(0).getRadius();

        for (Circle c : circles) {
            if (c.getCenterY() < top.getCenterY()) top = c;
            else if (c.getCenterY() > bottom.getCenterY()) bottom = c;
            if (c.getCenterX() < left.getCenterX()) left = c;
            else if (c.getCenterX() > right.getCenterX()) right = c;
        }

        double x = left.getCenterX() - radius;
        double y = top.getCenterY() - radius;
        double width = right.getCenterX() - left.getCenterX() + radius * 2;
        double height = bottom.getCenterY() - top.getCenterY() + radius * 2;
        Rectangle r = new Rectangle(x,y, width, height);
        r.setStroke(Color.BLACK);
        r.setFill(Color.TRANSPARENT);
        pane.getChildren().add(r);
    }

    public static void main(String[] args ){
        launch(args);
    }
    
}
