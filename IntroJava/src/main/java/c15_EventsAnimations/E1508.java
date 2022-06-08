/* 
(Display the mouse position) Write two programs, such that one displays the
mouse position when the mouse button is clicked (see Figure 15.28a), and the
other displays the mouse position when the mouse button is pressed and ceases
to display it when the mouse button is released.
 */
package chap15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;


public class E1508 extends Application {
    
    @Override
    public void start(Stage primaryStage) { 
        Text t = new Text();
        Pane pane = new Pane();
        pane.getChildren().add(t);

        Scene scene = new Scene(pane, 500,500);
        primaryStage.setTitle("Mouse position");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.setOnMousePressed(e -> {
            t.setX(e.getX());
            t.setY(e.getY());
            t.setText("(" + e.getX() + ", " + e.getY() + ")");
        });

        scene.setOnMouseReleased(e -> t.setText(""));
    }

    public static void main(String[] args ){
        launch(args);
    }  
}
