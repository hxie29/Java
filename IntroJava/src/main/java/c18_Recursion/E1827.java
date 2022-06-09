/*(Koch snowflake fractal) The text presented the Sierpinski triangle fractal. In
this exercise, you will write a program to display another fractal, called the Koch
snowflake, named after a famous Swedish mathematician. A Koch snowflake is
created as follows:
1. Begin with an equilateral triangle, which is considered to be the Koch fractal
of order (or level) 0, as shown in Figure 18.14a.
2. Divide each line in the shape into three equal line segments and draw an outward
equilateral triangle with the middle line segment as the base to create a
Koch fractal of order 1, as shown in Figure 18.14b.
3. Repeat Step 2 to create a Koch fractal of order 2, 3, . . . , and so on, as shown
in Figures 18.14c and d.*/
package c18_Recursion;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class E1827 extends Application {
    @Override
    public void start (Stage primaryStage) {
        BorderPane pane = new BorderPane();
        SnowflakePane flakePane = new SnowflakePane();

        TextField tf = new TextField();
        tf.setPrefColumnCount(4);
        Label lbInput = new Label("Enter an order: ", tf);
        lbInput.setContentDisplay(ContentDisplay.RIGHT);

        pane.setCenter(flakePane);
        pane.setBottom(lbInput);
        BorderPane.setAlignment(lbInput, Pos.CENTER);
        BorderPane.setAlignment(flakePane, Pos.CENTER);

        tf.setOnAction(e -> flakePane.setOrder(Integer.parseInt(tf.getText())));

        Scene scene = new Scene(pane, 200,210);
        primaryStage.setTitle("Sierpinski Triangle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
