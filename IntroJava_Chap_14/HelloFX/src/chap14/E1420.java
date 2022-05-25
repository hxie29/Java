/* 
(Draw an arrow line) Write a static method that draws an arrow line from a
starting point to an ending point in a pane using the following method header:
public static void drawArrowLine(double startX, double startY,
double endX, double endY, Pane pane)
Write a test program that randomly draws an arrow line, as shown in Figure 14.49a.
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
import javafx.scene.shape.Polyline;


public class E1420 extends Application {
    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10,10,10,10));
        drawArrowLine(100,200, 300, 400, pane);
       
        Scene scene = new Scene(pane, 600, 300);
        primaryStage.setTitle("Show cube function graph");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }

    public static void drawArrowLine(double startX, double startY, double endX, double endY, Pane pane) {
        Group group = new Group();

        //Create axis lines
        Line l = new Line(startX,startY, endX, endY);
        double angle = Math.atan((endX - startX) / (startY - endY));
        double arrowSize = 50;
        double arrowStartX = endX - arrowSize * Math.sin(Math.PI / 4 + angle);
        double arrowStartY = endY - arrowSize * Math.cos(Math.PI / 4 + angle);
        double arrowEndX = endX + arrowSize * Math.sin(angle - Math.PI / 4);
        double arrowEndY = endY - arrowSize * Math.cos(angle - Math.PI / 4);
        l.setStroke(Color.BLACK);
        Polyline arrow = new Polyline();
        arrow.getPoints().addAll(arrowStartX, arrowStartY, endX,endY, arrowEndX, arrowEndY);

        //Add axis lines, texts and find origin
        group.getChildren().addAll(l, arrow);
        pane.getChildren().add(group);
    }

}
