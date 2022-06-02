/* 
(Pattern recognition: consecutive four equal numbers) Write a GUI program
for Programming Exercise 8.19, as shown in Figures 16.49a–b. Let the user
enter the numbers in the text fields in a grid of 6 rows and 7 columns. The user
can click the Solve button to highlight a sequence of four equal numbers, if it
exists. Initially, the values in the text fields are randomly filled with numbers
from 0 to 9.
 */
package chap16;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class E1630 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        MatrixPane pane = new MatrixPane();
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Solve matrix consecutive four");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args ){
        launch(args);
    } 
}
