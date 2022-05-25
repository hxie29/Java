/* 
(Paint a smiley face) Write a program that paints a smiley face, as shown in
Figure 14.46a.
*/

package chap14;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;

public class E1411 extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(100,100,100,100));

        Circle c = new Circle();
        c.setStroke(Color.BLACK);
        c.setStrokeWidth(2);
        c.setFill(Color.WHITE);
        c.centerXProperty().bind(pane.widthProperty().divide(2));
        c.centerYProperty().bind(pane.heightProperty().divide(2));
        c.radiusProperty().bind(pane.widthProperty().multiply(0.4));
        
        Arc mouth = new Arc(200,200,50,10,180,180);
        mouth.centerXProperty().bind(c.centerXProperty());
        mouth.centerYProperty().bind(c.centerYProperty().add(c.radiusProperty().multiply(0.4)));
        mouth.radiusXProperty().bind(c.radiusProperty().multiply(0.5));
        mouth.radiusYProperty().bind(c.radiusProperty().multiply(0.2));
        mouth.setType(ArcType.OPEN);
        mouth.setStroke(Color.BLACK);
        mouth.setStrokeWidth(2);
        mouth.setFill(Color.WHITE);

        Line l1 = new Line();
        l1.setStroke(Color.BLACK);
        l1.setStrokeWidth(2);
        l1.startXProperty().bind(c.centerXProperty().subtract(mouth.radiusXProperty().divide(3)));
        l1.endXProperty().bind(c.centerXProperty().add(mouth.radiusXProperty().divide(3)));
        l1.startYProperty().bind(c.centerYProperty().add(c.radiusProperty().multiply(0.2)));
        l1.endYProperty().bind(l1.startYProperty());
        
        Line l2 = new Line();
        l2.setStroke(Color.BLACK);
        l2.setStrokeWidth(2);
        l2.startXProperty().bind(l1.endXProperty());
        l2.startYProperty().bind(l1.endYProperty());
        l2.endXProperty().bind(c.centerXProperty());
        l2.endYProperty().bind(c.centerYProperty().subtract(c.radiusProperty().multiply(0.2)));

        Ellipse e1 = new Ellipse();
        e1.setFill(Color.WHITE);
        e1.setStroke(Color.BLACK);
        e1.setStrokeWidth(2);
        e1.centerXProperty().bind(c.centerXProperty().subtract(c.radiusProperty().divide(2)));
        e1.centerYProperty().bind(c.centerYProperty().subtract(c.radiusProperty().divide(2)));
        e1.radiusXProperty().bind(c.radiusProperty().divide(4));
        e1.radiusYProperty().bind(e1.radiusXProperty().divide(2));

        Circle c1 = new Circle();
        c1.centerXProperty().bind(e1.centerXProperty());
        c1.centerYProperty().bind(e1.centerYProperty());
        c1.radiusProperty().bind(e1.radiusYProperty().multiply(0.8));
        c1.setFill(Color.BLACK);

        Ellipse e2 = new Ellipse();
        e2.setFill(Color.WHITE);
        e2.setStroke(Color.BLACK);
        e2.setStrokeWidth(2);
        e2.centerXProperty().bind(c.centerXProperty().add(c.radiusProperty().divide(2)));
        e2.centerYProperty().bind(e1.centerYProperty());
        e2.radiusXProperty().bind(e1.radiusXProperty());
        e2.radiusYProperty().bind(e1.radiusYProperty());

        Circle c2 = new Circle();
        c2.centerXProperty().bind(e2.centerXProperty());
        c2.centerYProperty().bind(e2.centerYProperty());
        c2.radiusProperty().bind(e2.radiusYProperty().multiply(0.8));
        c2.setFill(Color.BLACK);
        

        pane.getChildren().addAll(c, mouth, l1, l2, e1, c1, e2, c2);

        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setTitle("Smiley face");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }

}