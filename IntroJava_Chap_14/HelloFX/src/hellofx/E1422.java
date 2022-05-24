/* 
(Connect two circles) Write a program that draws two filled circles with radius
15 pixels, centered at random locations, with a line connecting the two circles.
The line should not cross inside the circles, as shown in Figure 14.49c.
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


public class E1422 extends Application {
    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10,10,10,10));
        double startX = Math.random() * 1000;
        double startY = Math.random() * 1500;
        double endX = Math.random() * 1500;
        double endY = Math.random() * 1500;
        circleLine(startX, startY, endX, endY, pane);
       
        Scene scene = new Scene(pane, 1600, 1300);
        primaryStage.setTitle("Show cube function graph");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }

    public static void circleLine(double startX, double startY, double endX, double endY, Pane pane) {
        Group group = new Group();

        Circle c1 = new Circle(startX, startY, 15);
        Text t1 = new Text(startX, startY, "1");
        Circle c2 = new Circle(endX, endY, 15);
        Text t2 = new Text(endX, endY, "2");
        t1.setFill(Color.BLACK);
        t2.setFill(Color.BLACK);
        c1.setStroke(Color.BLACK);
        c2.setStroke(Color.BLACK);
        c1.setFill(Color.WHITE);
        c2.setFill(Color.WHITE);
        Line l = new Line(startX,startY, endX, endY);
        l.setStroke(Color.BLACK);


        //Add axis lines, texts and find origin
        group.getChildren().addAll(l, c1, c2, t1, t2);
        pane.getChildren().add(group);
    }

}
