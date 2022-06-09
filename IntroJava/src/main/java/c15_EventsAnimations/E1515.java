/* 
(Geometry: add and remove points) Write a program that lets the user click on
a pane to dynamically create and remove points (see Figure 15.30a). When the
user left-clicks the mouse (primary button), a point is created and displayed
at the mouse point. The user can remove a point by pointing to it and rightclicking
the mouse (secondary button).
 */
package c15_EventsAnimations;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.Node;

public class E1515 extends Application {
    @Override
    public void start(Stage primaryStage) {

        Pane pane = new Pane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Show if mouse if in the circle");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        pane.setOnMouseClicked(e -> {
            ObservableList<Node> list = pane.getChildren();
            double x = e.getX();
            double y = e.getY();
            
            if (inside(list, x, y) >= 0) {
                list.remove(inside(list,x,y));
            }
            else {
                Circle c = new Circle(x, y, 20);
                c.setFill(Color.WHITE);
                c.setStroke(Color.BLACK);
                pane.getChildren().addAll(c);
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
    
}
