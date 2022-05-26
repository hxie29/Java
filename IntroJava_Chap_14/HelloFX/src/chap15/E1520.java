/*
(Geometry: display angles) Write a program that enables the user to drag the
vertices of a triangle and displays the angles dynamically as the triangle shape
changes, as shown in Figure 15.32a. The formula to compute angles is given in
Listing 4.1.
 */
package chap15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.Node;

public class E1520 extends Application {
    private Circle[] circles = {new Circle(100,50,10), 
                                new Circle (80, 150, 10),
                                new Circle (50,50,10)};

    private Pane pane = new Pane();
    private Double[] angle = new Double[3];
    private Polygon p = drawPolygon(circles[0], circles[1], circles[2]);
    
    private Text tA = new Text ();
    private Text tB = new Text ();
    private Text tC = new Text ();
    
    @Override
    public void start(Stage primaryStage) {
        findAngles();
        resetAllTexts();
        
        pane.getChildren().addAll(circles);
        pane.getChildren().addAll(p, tA, tB, tC);
        
        Scene scene = new Scene(pane, 800,800);
        primaryStage.setTitle("Drag a rectangle");
        primaryStage.setScene(scene);
        primaryStage.show();

        pane.setOnMouseDragged(e -> {
            for (Circle c: circles) {
                if (c.contains(e.getX(),e.getY())) {
                    c.setCenterX(e.getX());
                    c.setCenterY(e.getY());
                }
            }
            removeline();
            p = drawPolygon(circles[0], circles[1], circles[2]);
            pane.getChildren().add(p);

            findAngles();
            resetAllTexts();
        });
    }

    public static void main(String[] args ){
        launch(args);
    }

    private double calcAngleA(Circle a, Circle b, Circle c) {
        double sideA = distance(b, c);
        double sideB = distance(a, c);
        double sideC = distance(a, b);
        return Math.acos((sideA * sideA - sideB * sideB - sideC * sideC) / ( -2 * sideB * sideC)) * 180 / Math.PI;
    }

    private void findAngles() {
        angle[0] =  calcAngleA(circles[0], circles[1], circles[2]);
        angle[1] = calcAngleA(circles[1], circles[0], circles[2]);
        angle[2] = calcAngleA(circles[2], circles[1], circles[0]);
    }

    private double distance(Circle a, Circle b) {
        return Math.pow(((a.getCenterX() - b.getCenterX()) * (a.getCenterX() - b.getCenterX()) + (a.getCenterY() - b.getCenterY()) + (a.getCenterY() - b.getCenterY())), 0.5);
    }

    private Polygon drawPolygon(Circle a, Circle b, Circle c) {
        Polygon p = new Polygon();
        p.getPoints().addAll(a.getCenterX(),a.getCenterY(),b.getCenterX(),b.getCenterY(),c.getCenterX(),c.getCenterY());
        p.setStroke(Color.BLACK);
        p.setFill(Color.TRANSPARENT);
        return p;
    }

    private void removeline() {
        for (Node a: pane.getChildren()) {
            if (a instanceof Polygon) pane.getChildren().remove(a);
        }
    }

    private void resetText(Text t, Circle a, double angle) {
        t.setX(a.getCenterX());
        t.setY(a.getCenterY());
        t.setText(String.format("    %.2f", angle));
    }

    private void resetAllTexts() {
        resetText(tA, circles[0], angle[0]);
        resetText(tB, circles[1], angle[1]);
        resetText(tC, circles[2], angle[2]);
    }
 
}
