/* 
(Display a rectanguloid) Write a program that displays a rectanguloid, as
shown in Figure 14.47a. The cube should grow and shrink as the window grows
or shrinks.
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
import javafx.scene.shape.Polygon;
import javafx.scene.layout.Pane;

public class E1414 extends Application {
    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10,10,10,10));
        pane.getChildren().add(new Rectanguloid());
        
        Scene scene = new Scene(pane, 600, 300);
        primaryStage.setTitle("Rectanguloid");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }

}

class Rectanguloid extends Pane {
    private void paint() {

        double centerX = getWidth() / 2;
        double centerY = getHeight() / 2;
        double height = getHeight() * 0.6;
        double width = getWidth() * 0.8;
        double offsetX = getWidth() * 0.1;
        double offsetY = getHeight() * 0.15; 
        Double[] p1 = new Double[8];
        p1[0] = centerX - width / 2;
        p1[1] = centerY - height / 2;
        p1[2] = centerX + width / 2;
        p1[3] = p1[1];

        p1[4] = p1[2] - offsetX;
        p1[5] = p1[1] + offsetY;
        p1[6] = p1[0] - offsetX;
        p1[7] = p1[5];

        Double[] p2 = new Double [8];
        for (int i = 0; i < p2.length; i++) {
            if (i % 2 != 0) p2[i] = p1[i] + height;
            else p2[i] = p1[i];
        }

        Polygon t1 = new Polygon();
        t1.getPoints().addAll(p1);
        t1.setStroke(Color.BLACK);
        t1.setStrokeWidth(5);
        t1.setFill(Color.WHITE);
        Polygon t2 = new Polygon();
        t2.getPoints().addAll(p2);
        t2.setStroke(Color.BLACK);
        t2.setFill(Color.WHITE);
        t2.setStrokeWidth(5);

        Group group = new Group();
        group.getChildren().addAll(t1, t2);

        for (int i = 0; i < p1.length; i+=2) {
            Line l = new Line(p1[i], p1[i+1], p2[i], p2[i+1]);
            l.setStroke(Color.BLACK);
            l.setStrokeWidth(5);
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