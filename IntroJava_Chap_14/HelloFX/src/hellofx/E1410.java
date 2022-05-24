/* 
(Display a cylinder) Write a program that draws a cylinder, as shown in Figure 14.45b.
You can use the following method to set the dashed stroke for an arc:
arc.getStrokeDashArray().addAll(6.0, 21.0);

The solution posted on the website enables the cylinder to resize horizontally.
Can you revise it to resize vertically as well?
*/

package hellofx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;

public class E1410 extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(200,200,200,200));
        
        
        Ellipse r1 = new Ellipse(75,40,50,20);
        r1.setStroke(Color.BLACK);
        r1.setFill(Color.WHITE);
        
        Line l1 = new Line(r1.getCenterX() - r1.getRadiusX(),r1.getCenterY(), r1.getCenterX() - r1.getRadiusX(), 200);
        l1.setStroke(Color.BLACK);
        l1.setStrokeWidth(2);
        
        Line l2 = new Line(r1.getCenterX() + r1.getRadiusX(),r1.getCenterY(), r1.getCenterX() + r1.getRadiusX(), l1.getEndY());
        l2.setStroke(Color.BLACK);
        l2.setStrokeWidth(2);
        
        Arc a1 = new Arc(r1.getCenterX(),l1.getEndY(), r1.getRadiusX(), r1.getRadiusY(), 180,180);
        Arc a2 = new Arc(r1.getCenterX(),l1.getEndY(), r1.getRadiusX(), r1.getRadiusY(), 0,180);
        a1.setType(ArcType.OPEN);
        a1.setFill(Color.WHITE);
        a2.setType(ArcType.OPEN);
        a2.setFill(Color.WHITE);
        a1.setStroke(Color.BLACK);
        a2.setStroke(Color.BLACK);
        a1.setStrokeWidth(2);
        a2.setStrokeWidth(2);
        a2.getStrokeDashArray().addAll(3.0, 6.0);

        l1.endYProperty().bind(pane.heightProperty().subtract(pane.heightProperty().multiply(0.15)));
        l2.startXProperty().bind(l1.startXProperty().add(pane.widthProperty()).subtract(50));
        l2.endXProperty().bind(l1.endXProperty().add(pane.widthProperty()).subtract(50));
        l2.endYProperty().bind(l1.endYProperty());

        r1.centerXProperty().bind(pane.widthProperty().divide(2));
        r1.centerYProperty().bind(l1.startYProperty());
        r1.radiusXProperty().bind((pane.widthProperty().divide(2)).subtract(l1.startXProperty()));
        r1.radiusYProperty().bind(pane.heightProperty().multiply(0.1));
        
        a1.centerXProperty().bind(r1.centerXProperty());
        a1.centerYProperty().bind(l2.endYProperty());
        a2.centerXProperty().bind(r1.centerXProperty());
        a2.centerYProperty().bind(l2.endYProperty());
        a1.radiusXProperty().bind(r1.radiusXProperty());
        a2.radiusXProperty().bind(r1.radiusXProperty());
        a1.radiusYProperty().bind(r1.radiusYProperty());
        a2.radiusYProperty().bind(r1.radiusYProperty());


        pane.getChildren().addAll(l1, l2, r1, a1, a2);

        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setTitle("Cylinder");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }

}
