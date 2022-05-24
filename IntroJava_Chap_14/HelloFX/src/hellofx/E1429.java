/* 
(Game: bean machine) Write a program that displays a bean machine introduced
in Programming Exercise 7.37, as shown in Figure 14.52c.
}
*/

package hellofx;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;


public class E1429 extends Application {
    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10,10,10,10));

        pane.getChildren().add(new BeanMarchine(15));

        Scene scene = new Scene(pane, 1600, 1300);
        primaryStage.setTitle("Show polygon and a point");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }

}

class BeanMarchine extends Pane {
    private int row = 7;

    public BeanMarchine() {
    }

    public BeanMarchine(int row) {
        this.row = row;
    }

    private void paint() {
        double centerX = getWidth() / 2, centerY = getHeight() / 2;
        double hDis = Math.min(getHeight(), getWidth()) / (row * 2 + 1);
        double vDis = hDis * Math.pow(3, 0.5) / 2;
        double radius = hDis * 0.2;
        double bottomLength = vDis * 3;

        Group group = new Group();

        //Draw all the circles and lines connected to circles at the last row
        double x = centerX;
        double y = centerY - (row + 1) / 2 * vDis;

        //First find all the points for circles and lines connected to circles
        ArrayList<Double> circlePoints = new ArrayList<>();
        ArrayList<Double> linePoints = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < i + 1; j++) {
                x = centerX - hDis * ((i + 1) / 2.0 - j);
                circlePoints.add(x);
                circlePoints.add(y);
                Circle c = new Circle(x, y, radius);
                c.setFill(Color.BLACK);
                group.getChildren().add(c);

                if (i == row - 1) {
                    linePoints.add(x);
                    linePoints.add(y);
                    linePoints.add(x);
                    linePoints.add(y + bottomLength);
                }
            }
            y += vDis;
        }

        for (int i = 0; i < circlePoints.size(); i+=2) {
            Circle c = new Circle(circlePoints.get(i), circlePoints.get(i+1), radius);
                c.setFill(Color.BLACK);
                group.getChildren().add(c);
        }
        for (int i = 0; i < linePoints.size(); i+=4) {
            Line l = new Line(linePoints.get(i), linePoints.get(i+1), linePoints.get(i + 2), linePoints.get(i + 3));
            l.setStroke(Color.BLACK);
            group.getChildren().add(l);
        }

        //DrawOutline
        Line bottomL = new Line(linePoints.get(0) - hDis, linePoints.get(3), linePoints.get(linePoints.size() - 2) + hDis, linePoints.get(3));
        bottomL.setStroke(Color.RED);
        Line vLine1 = new Line(bottomL.getStartX(), bottomL.getStartY(), bottomL.getStartX(), bottomL.getStartY() - bottomLength);
        Line vLine2 = new Line(bottomL.getEndX(), bottomL.getEndY(), bottomL.getEndX(), bottomL.getEndY() - bottomLength);
        vLine1.setStroke(Color.RED);
        vLine2.setStroke(Color.RED);
        Line oblique1 = new Line(vLine1.getEndX(), vLine1.getEndY(), vLine1.getEndX() + hDis * row / 2.0, vLine1.getEndY() - hDis * row / 2 * Math.pow(3, 0.5));
        Line oblique2 = new Line(vLine2.getEndX(), vLine2.getEndY(), oblique1.getEndX() + hDis, oblique1.getEndY());
        oblique1.setStroke(Color.RED);
        oblique2.setStroke(Color.RED);
        Line top1 = new Line (oblique1.getEndX(), oblique1.getEndY(), oblique1.getEndX(), oblique1.getEndY() - vDis);
        Line top2 = new Line (oblique2.getEndX(), oblique2.getEndY(), oblique2.getEndX(), oblique2.getEndY() - vDis);
        top1.setStroke(Color.RED);
        top2.setStroke(Color.RED);
        group.getChildren().addAll(bottomL, vLine1, vLine2, oblique1, oblique2, top1, top2);

        getChildren().clear();
        getChildren().add(group);
    }

    @Override
    protected void setHeight(double arg0) {
        super.setHeight(arg0);
        paint();
    }

    @Override
    protected void setWidth(double arg0) {
        super.setWidth(arg0);
        paint();
    }
}
