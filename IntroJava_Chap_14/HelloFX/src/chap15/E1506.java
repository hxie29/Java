/* 
(Alternate two messages) Write a program to display the text Welcome to
java and LearningJavaFX alternately with a mouse click.
 */
package chap15;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public class E1506 extends Application {
    
    @Override
    public void start(Stage primaryStage) { 
        String[] s = {"Welcome to java", "Learning JavaFx"};

        Text t1 = new Text(s[0]);
        t1.setFill(Color.BLACK);
        Text t2 = new Text(s[1]);
        t2.setFill(Color.BLACK);

        VBox box = new VBox(10);
        box.getChildren().addAll(t1,t2);
        box.setAlignment(Pos.CENTER);
        BorderPane pane = new BorderPane();
        pane.setCenter(box);

        Scene scene = new Scene(pane, 500,500);
        primaryStage.setTitle("Alternate two messages");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.setOnMouseClicked(e -> swap(t1, t2, s));
    }

    public static void main(String[] args ){
        launch(args);
    }  

    public void swap(Text t1, Text t2, String[] s) {
        if (t1.getText().equals(s[0])) {
            t1.setText(s[1]);
            t2.setText(s[0]);
        }
        else {
            t1.setText(s[0]);
            t2.setText(s[1]);
        }
    }
}
