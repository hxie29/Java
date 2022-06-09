/* 
(Display a SLOW sign) Write a program that displays a SLOW sign, as shown in
Figure 14.47b. The octagon is in red and the sign is in white. (Hint: Place an
octagon and a text in a stack pane.)
*/

package c14_JavaFX;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class E1415 extends Application {
    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10,10,10,10));
        pane.getChildren().add(new Octagon());
        Text t = new Text("STOP");
        t.setStroke(Color.WHITE);
        t.setFill(Color.WHITE);
        t.setFont(new Font(60));
        pane.getChildren().add(t);
        
        Scene scene = new Scene(pane, 600, 300);
        primaryStage.setTitle("Stop sign");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }

}

