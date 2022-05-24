/* 
(Two circles and their distance) Write a program that draws two circles with
radius 15 pixels, centered at random locations, with a line connecting the two
circles. The distance between the two centers is displayed on the line, as shown
in Figure 14.49b.
}
*/

package hellofx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;


public class E1421 extends Application {
    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10,10,10,10));
        double startX = Math.random() * 1000;
        double startY = Math.random() * 1500;
        double endX = Math.random() * 1500;
        double endY = Math.random() * 1500;
        distanceLine(startX, startY, endX, endY, pane);
       
        Scene scene = new Scene(pane, 1600, 1300);
        primaryStage.setTitle("Show cube function graph");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }

    public static void distanceLine(double startX, double startY, double endX, double endY, Pane pane) {
        Group group = new Group();

        //Create axis lines
        Line l = new Line(startX,startY, endX, endY);
        Circle c1 = new Circle(startX, startY, 15);
        Circle c2 = new Circle(endX, endY, 15);
        l.setStroke(Color.BLACK);
        c1.setFill(Color.BLACK);
        c2.setFill(Color.BLACK);

        double distance = Math.pow(((endX - startX) * (endX - startX) + (endY - startY) * (endY - startY)),0.5);
        Text t = new Text( (startX + endX) / 2, (startY + endY) /2, ("  " + distance));

        //Add axis lines, texts and find origin
        group.getChildren().addAll(l,t, c1, c2);
        pane.getChildren().add(group);
    }

}
