/* 
(Plot the cube function) Write a program that draws a diagram for the function
f(x) = x3 (see Figure 14.48b).
Hint: Add points to a polyline using the following code:
Polyline polyline = new Polyline();
ObservableList<Double> list = polyline.getPoints();
double scaleFactor = 0.0125;
for (int x = –100; x <= 100; x++) {
list.add(x + 200.0);
list.add(scaleFactor * x * x * x);
}
*/

package chap14;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.layout.Pane;


public class E1416 extends Application {
    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10,10,10,10));
        pane.getChildren().add(new GridLines());
       
        Scene scene = new Scene(pane, 600, 300);
        primaryStage.setTitle("Show 4x4 grid lines");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }

}

class GridLines extends Pane {
    private void paint() {

        Group group = new Group();

        for (int i = 0; i < 3; i++) {
            Line l = new Line(0,0,getWidth(),0);
            l.setStroke(Color.BLUE);
            l.setStartY(getHeight() / 4 * (i +1));
            l.setEndY(getHeight() / 4 * (i +1));
            group.getChildren().add(l);
        }

        for (int i = 0; i < 3; i++) {
            Line l = new Line(0,0,0,getHeight());
            l.setStroke(Color.RED);
            l.setStartX(getWidth() / 4 * (i +1));
            l.setEndX(getWidth() / 4 * (i +1));
            group.getChildren().add(l);
        }

        getChildren().clear();
        getChildren().add(group);
    }

    @Override
    protected void setWidth(double arg0) {
        super.setWidth(arg0);
        paint();
    }

    @Override
    protected void setHeight(double arg0) {
        super.setHeight(arg0);
        paint();
    }
}