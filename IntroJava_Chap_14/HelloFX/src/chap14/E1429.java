/* 
(Game: bean machine) Write a program that displays a bean machine introduced
in Programming Exercise 7.37, as shown in Figure 14.52c.
}
*/

package chap14;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;



public class E1429 extends Application {
    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10,10,10,10));

        pane.getChildren().add(new BeanMachine(15));

        Scene scene = new Scene(pane, 1600, 1300);
        primaryStage.setTitle("Show polygon and a point");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }

}
