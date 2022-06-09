/* 
(Characters around circle) Write a program that displays a string Learning
JavaFX around the circle, as shown in Figure 14.44b. Hint: You need to display
each character in the right location with appropriate rotation using a loop.
 */

package c14_JavaFX;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class E1405 extends Application {
    @Override
    public void start(Stage primaryStage) {
        Group group = new Group();
        double radius = 200;
        double centerX = 300;
        double centerY = 300;
        
        String s = " JavaFX Learning";
        for (int i = 0 ; i < s.length(); i++) {
            Text t = new Text(s.charAt(i) + "");
            double degree =  360.0 / s.length() * i;
            t.setRotate(-90 + degree);
            t.setFont(Font.font("Times Roman", FontWeight.BOLD, FontPosture.ITALIC, 24));
            //To set text color use fill instead of stroke
            t.setFill(Color.BLACK);
            double x = centerX - radius * Math.cos(degree / 360 * Math.PI * 2);
            double y = centerY - radius * Math.sin(degree / 360 * Math.PI * 2);
            t.setX(x);
            t.setY(y);
            group.getChildren().add(t);
        }

        Scene scene = new Scene(new BorderPane(group));
        primaryStage.setTitle("Text");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
