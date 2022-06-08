/* 
(Enter and display a string) Write a program that receives a string from the
keyboard and displays it on a pane. The Enter key signals the end of a string.
Whenever a new string is entered, it is displayed on the pane.
 */
package chap15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.layout.BorderPane;


public class E1510 extends Application {
    
    @Override
    public void start(Stage primaryStage) { 
        BorderPane pane = new BorderPane();
        Text text = new Text("Ready to type");
        text.setFill(Color.BLACK);
        pane.setCenter(text);

        StringBuilder s = new StringBuilder();

        Scene scene = new Scene(pane, 500,500);
        primaryStage.setTitle("Enter text and display");
        primaryStage.setScene(scene);
        primaryStage.show();

        // scene does not required requestFocus
        pane.setOnKeyPressed(e -> {
           if (e.getCode() == KeyCode.ENTER) {
               text.setText(s.toString());
               s.delete(0, s.length());
           }
           else s.append(e.getCharacter() + "");
        });
        pane.requestFocus();
    }

    public static void main(String[] args ){
        launch(args);
    }  

}
