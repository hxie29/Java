/* 
(Display a rectanguloid) Write a program that displays a rectanguloid, as
shown in Figure 14.47a. The cube should grow and shrink as the window grows
or shrinks.
*/

package c14_JavaFX;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;

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

