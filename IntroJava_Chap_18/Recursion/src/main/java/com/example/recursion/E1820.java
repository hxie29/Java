/*(Display circles) Write a Java program that displays ovals, as shown in
Figure 18.12b. The circles are centered in the pane. The gap between two adjacent
circles is 10 pixels, and the gap between the border of the pane and the
largest circle is also 10.*/
package com.example.recursion;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class E1820 extends Application {
    @Override
    public void start (Stage primaryStage) {
        BorderPane pane = new BorderPane();
        OvalPane ovals = new OvalPane();
        pane.setCenter(ovals);

        Scene scene = new Scene(pane, 200,210);
        primaryStage.setTitle("Oval pane");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

class OvalPane extends StackPane {
    public OvalPane() {
        setHeight(400);
        setWidth(400);
        addShape();
    }

    private void addShape() {
        getChildren().clear();
        double x = getWidth() / 2 - 10;
        double y = getHeight() / 2- 10;
        addShape(x, y);
    }
    private void addShape(double x, double y) {
        if (x > 0 && y > 0) {
            Ellipse c = new Ellipse();
            c.setStroke(Color.BLACK);
            c.setFill(Color.TRANSPARENT);
            c.setRadiusX(x);
            c.setRadiusY(y);
            getChildren().add(c);
            addShape(x - 10, y - 10);
        }
    }
    @Override
    protected void setHeight(double v) {
        super.setHeight(v);
        addShape();
    }

    @Override
    protected void setWidth(double v) {
        super.setWidth(v);
        addShape();
    }
}
