/*(Largest block) The problem for finding a largest block is described in
Programming Exercise 8.35. Design a dynamic programming algorithm for
solving this problem in O(n2) time. Write a test program that displays a 10- by-
10 square matrix, as shown in Figure 22.14a. Each element in the matrix is 0 or
1, randomly generated with a click of the Refresh button. Display each number
centered in a text field. Use a text field for each entry. Allow the user to change
the entry value. Click the Find Largest Block button to find a largest square
submatrix that consists of 1s. Highlight the numbers in the block, as shown
in Figure 22.14b. See liveexample.pearsoncmg.com/dsanimation/LargestBlock
.html for an interactive test.

*/
package c22_EfficientAlgorithms;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class E2219  extends Application {
    @Override
    public void start(Stage primaryStage) {
        LargestBlockPane pane = new LargestBlockPane();

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Find largest block in matrix");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
