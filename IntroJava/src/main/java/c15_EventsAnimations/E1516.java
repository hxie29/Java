/* 
(Two movable vertices and their distances) Write a program that displays two
circles with radius 10 at location (40, 40) and (120, 150) with a line connecting
the two circles, as shown in Figure 15.30b. The distance between the circles
is displayed along the line. The user can drag a circle. When that happens, the
circle and its line are moved, and the distance between the circles is updated.
 */
package c15_EventsAnimations;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.Node;

public class E1516 extends Application {
    @Override
    public void start(Stage primaryStage) {

        Pane pane = new Pane();
        pane.setPadding(new Insets(10, 10, 10, 10));

        Circle c1 = new Circle(40, 40, 10);
        c1.setFill(Color.WHITE);
        c1.setStroke(Color.BLACK);
        Circle c2 = new Circle(120, 150, 10);
        c2.setFill(Color.WHITE);
        c2.setStroke(Color.BLACK);

        Line l = new Line(c1.getCenterX(), c1.getCenterY(), c2.getCenterX(), c2.getCenterY());
        l.setStroke(Color.BLACK);
        double d = distance(c1, c2);
        Text text = new Text(((c1.getCenterX() + c2.getCenterX()) / 2), ((c1.getCenterY() + c2.getCenterY()) /2) ,d +"");
        text.setStroke(Color.BLACK);

        pane.getChildren().addAll(l,c1,c2,text);
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Drag show two circle and its distance");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        scene.setOnMouseDragged(e -> {
            double x = e.getX();
            double y = e.getY();
            if (c1.contains(x,y)) {
                drag(c1, c2, x, y, text);
                l.setStartX(x);
                l.setStartY(y);
            }
            else if (c2.contains(x,y)) {
                drag(c2, c1, x, y, text);
                l.setEndX(x);
                l.setEndY(y);
            }
        });
        
    }

    public static void main(String[] args ){
        launch(args);
    }

    public int inside(ObservableList<Node> list, double x, double y) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains(x, y)) return i;
        }
        return -1;
    }

    public double distance(Circle c1, Circle c2) {
        return Math.pow(((c1.getCenterX() - c2.getCenterX()) * (c1.getCenterX() - c2.getCenterX()) 
        + (c1.getCenterY() - c2.getCenterY()) * (c1.getCenterY() - c2.getCenterY())), 0.5);   
    }

    public void drag (Circle c1, Circle other, double x, double y, Text text) {
        c1.setCenterX(x);
        c1.setCenterY(y);
        double d = distance(c1, other);
        text.setText("" + d);
        text.setX((c1.getCenterX() + other.getCenterX()) / 2);
        text.setY((c1.getCenterY() + other.getCenterY()) /2);
    }
    
}
